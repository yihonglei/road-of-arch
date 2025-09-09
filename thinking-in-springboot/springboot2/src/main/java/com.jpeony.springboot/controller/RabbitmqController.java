//package com.jpeony.springboot.controller;
//
//import com.jpeony.springboot.message.producter.JpeonyProductor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Spring Boot集成RabbitMQ
// *
// * @author yihonglei
// */
//@RestController
//public class RabbitmqController {
//
//    @Autowired
//    private JpeonyProductor jpeonyProductor;
//
//    @RequestMapping("/testMqSender/{msg}")
//    public String testMqSender(@PathVariable("msg") String msg) {
//        jpeonyProductor.sendMsg(msg);
//        return "OK";
//    }
//
//    @RequestMapping("/testFanoutMqSender/{msg}")
//    public String testFanoutMqSender(@PathVariable("msg") String msg) {
//        jpeonyProductor.sendMsg2Fanout(msg);
//        return "OK";
//    }
//
//    @RequestMapping("/testTopicSender/{msg}")
//    public String testTopicSender(@PathVariable("msg") String msg) {
//        jpeonyProductor.sendMsg2Topic(msg);
//        return "OK";
//    }
//}
