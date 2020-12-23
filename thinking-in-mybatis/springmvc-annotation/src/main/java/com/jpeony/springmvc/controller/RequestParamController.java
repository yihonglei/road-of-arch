package com.jpeony.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * RequestParam注解绑定请求参数
 *
 * @author yihonglei
 */
@Controller
@RequestMapping("/testRP")
public class RequestParamController {
    private static final String SUCCESS = "success";

    /**
     * @RequestParam 映射请求参数
     * value 请求参数的参数名 ，作为参数映射名称
     * required 该参数是否必填，默认为true(必填)，当设置成必填时，如果没有传入参数，报错
     * defaultValue 设置请求参数的默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(
            @RequestParam("username") String username,
            @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam,username=" + username + ",age=" + age);
        return SUCCESS;
    }
}
