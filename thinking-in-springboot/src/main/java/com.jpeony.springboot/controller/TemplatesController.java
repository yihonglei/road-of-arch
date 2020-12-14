package com.jpeony.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 注意:
 * 这个地方使用的是@Controller，而不是@RestController，用的是spring MVC逻辑，
 * 在spring MVC中，需要在spring mvc配置的视图解析器中指定视图文件位置，spring boot使用
 * thymeleaf等于将视图地址默认在src/main/resources/templates下了
 *
 * @author yihonglei
 */
@Controller
@RequestMapping("/templates")
public class TemplatesController {

    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String, Object> map) {
        map.put("nameKey", "Thymeleaf");

        // 返回的hello对应src/main/resources/templates下的hello.html页面
        return "hello";
    }


    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String, Object> map) {
        map.put("nameKey", "freemarker");

        // 返回的testFtl对应src/main/resources/templates下的testFtl.ftl
        return "testFtl";
    }

}
