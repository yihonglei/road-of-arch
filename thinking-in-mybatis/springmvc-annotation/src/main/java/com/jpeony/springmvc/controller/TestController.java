package com.jpeony.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 测试跨域
 *
 * @author yihonglei
 */
@Controller
public class TestController {

    @RequestMapping("/testCros")
    public String testCookieValue(HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin","*");// request.getHeader("Origin")
//        response.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3000");
//        response.setHeader("Access-Control-Allow-Headers","accept, content-type, x-session-token, x-requested-with");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Cache-Control","no-cache");
        return "cros";
    }

}
