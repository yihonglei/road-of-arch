package com.jpeony.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yihonglei
 */
@Controller
@RequestMapping("/testCV")
public class CookieValueController {
    private static final String SUCCESS="success";
    /**
     * @RequestParam 映射请求参数
     * value 请求参数的参数名
     * required 该参数是否必填，默认为true(必填)，当设置成必填时，如果没有传入参数，报错
     * defaultValue 设置请求参数的默认值
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId ) {
        System.out.println("testCookieValue,sessionId="+sessionId);
        return SUCCESS;
    }
}
