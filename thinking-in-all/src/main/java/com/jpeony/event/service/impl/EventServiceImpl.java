package com.jpeony.event.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jpeony.event.entity.BagEvent;
import com.jpeony.event.entity.BagFile;
import com.jpeony.event.service.EventService;
import com.jpeony.event.util.OkHttpCli;
import com.jpeony.event.util.ZipCompressor;
import com.jpeony.ipc.http.IpcController;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.Result;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.messages.Item;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("EventService")
public class EventServiceImpl implements EventService {
    private static Logger logger = LoggerFactory.getLogger(IpcController.class);

    @Value("${minio.endPoint}")
    private String endPoint;

    @Value("${minio.port}")
    private Integer port;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${txt.path}")
    private String txtPath;

    @Value("${bag.path}")
    private String bagPath;

    @Value("${bagevent.url}")
    private String bagEventUrl;

    public static final String CLIENTID = System.getProperty("spring.netty.clientId", "10010001");

    @Autowired
    private OkHttpCli okHttpCli;

    private static boolean jobFlag = false;

    @Value("${bagevent.file.intervaltime}")
    private Integer intervalTime;

    private static MinioClient instance;

    public MinioClient getInstance() throws InvalidPortException, InvalidEndpointException {
        if (instance == null) {
            instance = new MinioClient(this.endPoint, this.port.intValue(), this.accessKey, this.secretKey);
        }
        return instance;
    }

    @Override
    public boolean bagEventJob() {
        if (jobFlag) {
            System.err.println("上次处理未完成，停止本次处理");
            return true;
        }
        jobFlag = true;
        List<BagEvent> bagEventList = findBagEventByClientId();
        if (bagEventList == null) {
            System.err.println("微服务问题，本次无处理！");
            jobFlag = false;
            return false;
        }
        if (bagEventList.size() == 0) {
            bagEventList = getCurrentDateEvent();
        } else {
            bagEventList = getContinueEvent(bagEventList.get(0));
        }
        LinkedHashMap<String, List<BagEvent>> fileMap = getBagFileList(bagEventList);
        if (fileMap == null || fileMap.size() == 0) {
            System.err.println("无bag文件，本次无处理！");
            jobFlag = false;
            return true;
        }
        List<String> bagCache = getBagCache(this.bucketName);
        for (String path : fileMap.keySet()) {
            if (bagCache.contains(CLIENTID + "/" + path)) {
                List<BagEvent> list = fileMap.get(path);
                if (list != null && list.size() > 0) {
                    insertMongo(list);
                    System.err.println("只创建了事件" + ((List) list.stream().map(s -> s.getTimeStr()).collect(Collectors.toList())).toString());
                }
                continue;
            }
            try {
                String fileName = CLIENTID + "/" + path + ".zip";
                byte[] bb = ZipCompressor.zipByteArrayOutputStream(this.bagPath + path);
                InputStream inputStream = new ByteArrayInputStream(bb);
                long t1 = System.currentTimeMillis();
                getInstance().putObject(this.bucketName, fileName, inputStream, new PutObjectOptions(inputStream.available(), -1L));
                long t2 = System.currentTimeMillis();
                System.err.println("只上传了文件" + fileName + "  用时" + ((t2 - t1) / 1000L) + "s");
                List<BagEvent> list = fileMap.get(path);
                if (list != null && list.size() > 0) {
                    for (BagEvent s : list) {
//                    s.getFiles().stream().forEach(());
                    }
                    insertMongo(list);
                    System.err.println("创建了事件" + ((List) list.stream().map(s -> s.getTimeStr()).collect(Collectors.toList())).toString());
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        System.err.println("本次处理结束！");
        jobFlag = false;
        return true;
    }

    private List<BagEvent> getCurrentDateEvent() {
        List<BagEvent> bagEventList = new ArrayList<>();
        long t1 = System.currentTimeMillis();
        List<File> files = Arrays.asList((new File(this.txtPath)).listFiles());
        Collections.sort(files, (Comparator<? super File>) new Object(this));
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        String current = format2.format(Calendar.getInstance().getTime()) + "00-00-00";
        for (File f : files) {
            String name = f.getName();
            System.out.println("txt file :" + name);
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
                String strLine = null;
                List<String> fileList = new ArrayList<>();
                while (null != (strLine = bufferedReader.readLine())) {
                    String[] strs = strLine.replaceAll("eventrecord/", "").split("\t");
                    String compareTime = getDate();
                    if (strs[0].compareTo(compareTime) > 0) {
                        break;
                    }
                    BagEvent bagEvent = new BagEvent();
                    bagEvent.setClientId(CLIENTID);
                    bagEvent.setTimeStr(strs[0]);
                    bagEvent.setTime(format1.parse(strs[0]));
                    bagEvent.setRelativeTime(strs[1]);
                    bagEvent.setType(strs[2]);
                    bagEventList.add(bagEvent);
                    System.out.println("bagEvent is :" + strs[0] + "==>>" + bagEvent.getTime());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long t2 = System.currentTimeMillis();
        logger.info("getCurrentDateEvent time is {} ms, and bagEventList is {}", Long.valueOf(t2 - t1), bagEventList.toString());
        return bagEventList;
    }

    private List<BagEvent> getContinueEvent(BagEvent be) {
        List<BagEvent> bagEventList = new ArrayList<>();
        long t1 = System.currentTimeMillis();
        List<File> files = Arrays.asList((new File(this.txtPath)).listFiles());
        Collections.sort(files, (Comparator<? super File>) new Object(this));
        boolean flag = false;
        boolean checkFlag = false;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        for (File f : files) {
            String name = f.getName();
            System.out.println("txt file :" + name);
            if (f.isDirectory()) {
                continue;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
                String strLine = null;
                List<String> fileList = new ArrayList<>();
                while (null != (strLine = bufferedReader.readLine())) {
                    String[] strs = strLine.replaceAll("eventrecord/", "").split("\t");
                    checkFlag = true;
                    if (flag) {
                        String compareTime = getDate();
                        if (strs[0].compareTo(compareTime) > 0) {
                            break;
                        }
                        BagEvent bagEvent = new BagEvent();
                        bagEvent.setClientId(CLIENTID);
                        bagEvent.setTimeStr(strs[0]);
                        bagEvent.setTime(format.parse(strs[0]));
                        bagEvent.setRelativeTime(strs[1]);
                        bagEvent.setType(strs[2]);
                        bagEventList.add(bagEvent);
                        System.out.println("bagEvent is :" + strs[0] + "==>>" + bagEvent.getTime());
                        continue;
                    }
                    if (be.getTimeStr().equals(strs[0]) && be.getRelativeTime().equals(strs[1])) {
                        flag = true;
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long t2 = System.currentTimeMillis();
        logger.info("getContinueEvent time is {} ms, and bagEventList is {}", Long.valueOf(t2 - t1), bagEventList.toString());
        if ((bagEventList == null || bagEventList.size() == 0) && files.size() > 0 && checkFlag) {
            bagEventList = getCurrentDateEvent();
            long t3 = System.currentTimeMillis();
            logger.info("getContinueEvent restart time is {} ms, and bagEventList is {}", Long.valueOf(t3 - t2), bagEventList.toString());
        }
        return bagEventList;
    }

    private LinkedHashMap<String, List<BagEvent>> getBagFileList(List<BagEvent> bagEventList) {
        long t1 = System.currentTimeMillis();
        List<File> files = Arrays.asList((new File(this.bagPath)).listFiles());
        Collections.sort(files, (Comparator<? super File>) new Object(this));
        Map<Integer, BagFile> map = new HashMap<>();
        for (File ff : files) {
            String name = ff.getName();
            if (ff.getName().indexOf(".bag") == -1) {
                continue;
            }
            BagFile bagFile = new BagFile();
            bagFile.setName(name);
            bagFile.setSize(ff.length());
            map.put(Integer.valueOf(Integer.parseInt(name.substring(name.indexOf("_") + 1, name.indexOf(".")))), bagFile);
        }
        LinkedHashMap<String, List<BagEvent>> fileMap = new LinkedHashMap<>();
        for (BagEvent bagEvent : bagEventList) {
            fileMap = getBagFile(map, fileMap, bagEvent);
        }
        long t2 = System.currentTimeMillis();
        logger.info("getBagFileList time is {} ms, and fileMap is {}", Long.valueOf(t2 - t1), fileMap.toString());
        return fileMap;
    }

    private LinkedHashMap<String, List<BagEvent>> getBagFile(Map<Integer, BagFile> map, LinkedHashMap<String, List<BagEvent>> fileMap, BagEvent bagEvent) {
        System.out.println("current BagEvent is " + bagEvent.getTimeStr());
        String time = bagEvent.getTimeStr();
        for (int i = 0; i < map.size() - 1; i++) {
            BagFile bagFile = map.get(Integer.valueOf(i));
            BagFile bagFile1 = map.get(Integer.valueOf(i + 1));
            String name = bagFile.getName();
            String name1 = bagFile1.getName();
            Integer nameFlag = Integer.valueOf(Integer.parseInt(name.substring(name.indexOf("_") + 1, name.indexOf("."))));
            Integer nameFlag1 = Integer.valueOf(Integer.parseInt(name1.substring(name1.indexOf("_") + 1, name1.indexOf("."))));
            if (time.compareTo(name.substring(0, name.indexOf("_"))) > 0 && name1.substring(0, name1.indexOf("_")).compareTo(time) > 0) {
                System.out.println("合适的文件：" + name);
                if (i == 0) {
                    if (nameFlag.intValue() >= nameFlag1.intValue()) {
                        List<BagEvent> list3 = new ArrayList<>();
                        List<BagFile> list4 = new ArrayList<>();
                        BagFile bagFile4 = new BagFile();
                        bagFile4.setName(name);
                        bagFile4.setSize(bagFile.getSize());
                        list4.add(bagFile4);
                        bagEvent.setFiles(list4);
                        list3.add(bagEvent);
                        fileMap.put(name, list3);
                        break;
                    }
                    fileMap.put(name, (List<BagEvent>) null);
                    List<BagEvent> list1 = new ArrayList<>();
                    List<BagFile> list2 = new ArrayList<>();
                    BagFile bagFile2 = new BagFile();
                    bagFile2.setName(name);
                    bagFile2.setSize(bagFile.getSize());
                    list2.add(bagFile2);
                    BagFile bagFile3 = new BagFile();
                    bagFile3.setName(name1);
                    bagFile3.setSize(bagFile1.getSize());
                    list2.add(bagFile3);
                    bagEvent.setFiles(list2);
                    list1.add(bagEvent);
                    fileMap.put(name1, list1);
                    break;
                }
                if (!fileMap.containsKey(((BagFile) map.get(Integer.valueOf(i - 1))).getName())) {
                    fileMap.put(((BagFile) map.get(Integer.valueOf(i - 1))).getName(), (List<BagEvent>) null);
                }
                if (nameFlag.intValue() >= nameFlag1.intValue()) {
                    List<BagEvent> list1 = fileMap.get(Integer.valueOf(i));
                    if (list1 == null || list1.size() == 0)
                        list1 = new ArrayList<>();
                    List<BagFile> list2 = new ArrayList<>();
                    BagFile bagFile2 = new BagFile();
                    bagFile2.setName(((BagFile) map.get(Integer.valueOf(i - 1))).getName());
                    bagFile2.setSize(((BagFile) map.get(Integer.valueOf(i - 1))).getSize());
                    list2.add(bagFile2);
                    BagFile bagFile3 = new BagFile();
                    bagFile3.setName(name);
                    bagFile3.setSize(bagFile.getSize());
                    list2.add(bagFile3);
                    bagEvent.setFiles(list2);
                    list1.add(bagEvent);
                    fileMap.put(name, list1);
                    break;
                }
                if (!fileMap.containsKey(name)) {
                    fileMap.put(name, (List<BagEvent>) null);
                }
                List<BagEvent> list = fileMap.get(name1);
                if (list == null || list.size() == 0)
                    list = new ArrayList<>();
                List<BagFile> bagFiles = new ArrayList<>();
                BagFile bf0 = new BagFile();
                bf0.setName(((BagFile) map.get(Integer.valueOf(i - 1))).getName());
                bf0.setSize(((BagFile) map.get(Integer.valueOf(i - 1))).getSize());
                bagFiles.add(bf0);
                BagFile bf = new BagFile();
                bf.setName(name);
                bf.setSize(bagFile.getSize());
                bagFiles.add(bf);
                BagFile bf1 = new BagFile();
                bf1.setName(name1);
                bf1.setSize(bagFile1.getSize());
                bagFiles.add(bf1);
                bagEvent.setFiles(bagFiles);
                list.add(bagEvent);
                fileMap.put(name1, list);
                break;
            }
        }
        return fileMap;
    }

    private List<BagEvent> findBagEventByClientId() {
        List<BagEvent> list = new ArrayList<>();
        String url = this.bagEventUrl + "/event/bagEvent/clientId?clientId=" + CLIENTID;
        String message = this.okHttpCli.doGet(url);
        JSONObject jsonObject = JSONObject.parseObject(message);
        if (jsonObject == null) {
            return null;
        }
        if (jsonObject.getInteger("code").intValue() == 200) {
            String data = jsonObject.getString("data");
            if (!StringUtils.isEmpty(data)) {
                list = JSONArray.parseArray(data, BagEvent.class);
            }
        }
        return list;
    }

    private void insertMongo(List<BagEvent> list) {
        logger.info("insertMongo list is {}", list.toString());
        String url = this.bagEventUrl + "/event/bagEvent";
        String jsonString = JSONObject.toJSONString(list);
        logger.info("insertMongourl准备调用ad-dm，url={},请求参数jsonString={}", url, jsonString);
        String message = this.okHttpCli.doPostJson(url, jsonString);
        logger.info("insertMongo请求的返回值message={}", message);
        JSONObject jsonObject = JSONObject.parseObject(message);
    }

    private List<String> getBagCache(String bucketName) {
        List<String> bagCache = new ArrayList<>();
        try {
            Iterable<Result<Item>> iter = getInstance().listObjects(bucketName, CLIENTID);
            for (Result<Item> item : iter) {
                Item it = (Item) item.get();
                bagCache.add(it.objectName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bagCache;
    }

    private void addList(List<String> list, String s) {
        if (!list.contains(s)) {
            list.add(s);
        }
    }

    private void addMap(Map<String, List<BagEvent>> map, String s, List<BagEvent> list) {
        if (!map.containsKey(s)) {
            map.put(s, list);
        }
    }

    private String getDate() {
        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(12, -2 * this.intervalTime.intValue());
        Date beforeD = beforeTime.getTime();
        String before5 = (new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")).format(beforeD);
        return before5;
    }
}
