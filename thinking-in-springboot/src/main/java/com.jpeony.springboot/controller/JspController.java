package com.jpeony.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * jsp首页【Spring Boot一般使用前后端分离，很少直接使用jsp】
 *
 * @author yihonglei
 */
@Controller
public class JspController {

    @RequestMapping("/index")
    public String index(Map<String, Object> map) {
        map.put("nameKey", "Test jsp!");

        return "index";
    }

}
