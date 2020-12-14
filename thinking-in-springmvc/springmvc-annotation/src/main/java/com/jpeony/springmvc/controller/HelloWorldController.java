package com.jpeony.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller测试
 *
 * @author yihonglei
 */
@Controller
public class HelloWorldController {
    /**
     * 1、通过RequestMapping注解映射请求URL。
     * 2、返回值通过InternalResourceViewResolver解析到实际的视图，解析方式：
     * 前缀(prefix) + 返回值(returnVal) + 后缀(suffix)得到视图，通过转发器转发操作。
     * <p>
     * 比如这个实例解析的实际视图路径如下：
     * /WEB-INF/views/success.jsp
     */
    @RequestMapping("/helloworld")
    public String hello() {
        return "success";
    }
}
