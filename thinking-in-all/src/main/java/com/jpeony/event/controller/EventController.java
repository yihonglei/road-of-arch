package com.jpeony.event.controller;

import com.jpeony.event.service.EventService;
import com.jpeony.ipc.http.response.ResponseData;
import com.jpeony.ipc.http.response.SuccessResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/event"})
public class EventController {
    @Autowired
    private EventService bagService;

    @GetMapping
    @ResponseBody
    public ResponseData tagAndFile() {
        this.bagService.bagEventJob();
        return (ResponseData) new SuccessResponseData();
    }
}