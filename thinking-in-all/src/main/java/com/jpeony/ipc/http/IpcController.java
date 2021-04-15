package com.jpeony.ipc.http;


import com.jpeony.ipc.http.dto.TagFileDto;
import com.jpeony.ipc.http.response.ErrorResponseData;
import com.jpeony.ipc.http.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/ipcUpload"})
public class IpcController {
    private static Logger logger = LoggerFactory.getLogger(IpcController.class);

    @RequestMapping({"/tagAndFile"})
    @ResponseBody
    public ResponseData tagAndFile(@RequestBody TagFileDto tagFileDto) {
        logger.info("传入参数：{}", tagFileDto.toString());
        return (ResponseData) new ErrorResponseData();
    }
}
