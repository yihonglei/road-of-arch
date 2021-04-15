package com.jpeony.event.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import com.jpeony.ipc.http.IpcController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipCompressor {
    private static Logger log = LoggerFactory.getLogger(IpcController.class);

    static final int BUFFER = 8192;

    private File zipFile;

    public ZipCompressor() {
    }

    public ZipCompressor(String pathName) {
        this.zipFile = new File(pathName);
    }

    public void compress(String... pathName) {
        ZipOutputStream out = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream, new CRC32());
            out = new ZipOutputStream(cos);
            String basedir = "";
            for (int i = 0; i < pathName.length; i++) {
                compress(new File(pathName[i]), out, basedir);
            }
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void compress(File file, ZipOutputStream out, String basedir) {
        if (file.isDirectory()) {
            log.info("压缩：" + basedir + file.getName());
            compressDirectory(file, out, basedir);
        } else {
            log.info("压缩：" + basedir + file.getName());
            compressFile(file, out, basedir);
        }
    }

    public void compressDirectory(File dir, ZipOutputStream out, String basedir) {
        if (!dir.exists()) {
            log.info("压缩目录不存在，请核实！");
            return;
        }
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            compress(files[i], out, basedir + dir.getName() + "/");
        }
    }

    private void compressFile(File file, ZipOutputStream out, String basedir) {
        if (!file.exists()) {
            log.info("压缩文件不存在，请核实！");
            return;
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(basedir + file.getName());
            out.putNextEntry(entry);
            byte[] data = new byte[8192];
            int count;
            while ((count = bis.read(data, 0, 8192)) != -1) {
                out.write(data, 0, count);
            }
            bis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void compressSingle(String srcPathName) {
        File file = new File(srcPathName);
        if (!file.exists()) {
            throw new RuntimeException(srcPathName + "不存在！");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream, new CRC32());
            ZipOutputStream out = new ZipOutputStream(cos);
            String basedir = "";
            compress(file, out, basedir);
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void unZipFiles(String zipPath, String descDir) throws IOException {
        log.info("文件:{}. 解压路径:{}. 解压开始.", zipPath, descDir);
        long start = System.currentTimeMillis();
        try {
            File zipFile = new File(zipPath);
            System.err.println(zipFile.getName());
            if (!zipFile.exists()) {
                throw new IOException("需要解压文件不存在");
            }
            File pathFile = new File(descDir);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
            for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = entries.nextElement();
                String zipEntryName = entry.getName();
                System.err.println(zipEntryName);
                InputStream in = zip.getInputStream(entry);
                String outPath = (descDir + File.separator + zipEntryName).replaceAll("\\*", "/");
                System.err.println(outPath);
                File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
                if (!file.exists()) {
                    file.mkdirs();
                }
                if ((new File(outPath)).isDirectory()) {
                    continue;
                }
                OutputStream out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[1024];
                int len;
                while ((len = in.read(buf1)) > 0) {
                    out.write(buf1, 0, len);
                }
                in.close();
                out.close();
            }
            log.info("文件:{}. 解压路径:{}. 解压完成. 耗时:{}ms. ", new Object[]{zipPath, descDir, Long.valueOf(System.currentTimeMillis() - start)});
        } catch (Exception e) {
            log.info("文件:{}. 解压路径:{}. 解压异常:{}. 耗时:{}ms. ", new Object[]{zipPath, descDir, e, Long.valueOf(System.currentTimeMillis() - start)});
            throw new IOException(e);
        }
    }

    public static byte[] compressNoFile(String... pathName) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ZipOutputStream zipOut = new ZipOutputStream(output);
        try {
            String basedir = "";
            for (int i = 0; i < pathName.length; i++) {
                compressNoFile(new File(pathName[i]), zipOut, basedir);
            }
            output.close();
            zipOut.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return output.toByteArray();
    }

    private static void compressNoFile(File file, ZipOutputStream zipOut, String basedir) {
        if (file.isDirectory()) {
            log.info("压缩："+ basedir + file.getName());
            compressDirectoryNoFile(file, zipOut, basedir);
        } else {
            log.info("压缩："+ basedir + file.getName());
            compressFileNoFile(file, zipOut, basedir);
        }
    }

    public static void compressDirectoryNoFile(File dir, ZipOutputStream zipOut, String basedir) {
        if (!dir.exists()) {
            log.info("压缩目录不存在，请核实！");
            return;
        }
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            compressNoFile(files[i], zipOut, basedir + dir.getName() + "/");
        }
    }

    private static void compressFileNoFile(File f, ZipOutputStream zipOut, String basedir) {
        if (!f.exists()) {
            log.info("压缩文件不存在，请核实！");
            return;
        }
        try {
            String fileName = f.getName();
            ByteArrayInputStream bais = new ByteArrayInputStream(getBytesByFile(f));
            zipOut.putNextEntry(new ZipEntry(fileName));
            int temp = 0;
            while ((temp = bais.read()) != -1) {
                zipOut.write(temp);
            }
            bais.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] zipByteArrayOutputStream(String path) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zipOut = new ZipOutputStream(baos);
        ByteArrayInputStream bais = null;
        String fileName = null;
        int temp = 0;
        File f = new File(path);
        fileName = f.getName();
        bais = new ByteArrayInputStream(getBytesByFile(f));
        zipOut.putNextEntry(new ZipEntry(fileName));
        byte[] data = new byte[8192];
        while ((temp = bais.read(data, 0, 8192)) != -1) {
            zipOut.write(data, 0, temp);
        }
        bais.close();
        zipOut.close();
        baos.close();
        return baos.toByteArray();
    }

    public static byte[] batchZipByteArrayOutputStream() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zipOut = new ZipOutputStream(baos);
        ByteArrayInputStream bais = null;
        String fileName = null;
        int temp = 0;
        File folder = new File("D:/zip/upzip");
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            fileName = f.getName();
            bais = new ByteArrayInputStream(getBytesByFile(f));
            zipOut.putNextEntry(new ZipEntry(fileName));
            temp = 0;
            while ((temp = bais.read()) != -1) {
                zipOut.write(temp);
            }
            bais.close();
        }
        zipOut.close();
        baos.close();
        return baos.toByteArray();
    }

    private static byte[] getFileDataAsBytes(File f) {
        byte[] bs = new byte[(int) f.length()];
        try {
            InputStream in = new FileInputStream(f);
            BufferedInputStream bin = new BufferedInputStream(in);
            int index = 0;
            byte[] buf1 = new byte[8196];
            int c;
            while ((c = bin.read(buf1)) != -1) {
                bs[index++] = (byte) c;
            }
            bin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println(bs.length);
        return bs;
    }

    public static byte[] getBytesByFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
