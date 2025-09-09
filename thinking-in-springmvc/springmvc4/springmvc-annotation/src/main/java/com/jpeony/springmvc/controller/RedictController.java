package com.jpeony.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author yihonglei
 */
@Controller
@RequestMapping("/springRedirect")
public class RedictController {

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println("redirect重定向测试");
        return "redirect:/indexRedict.jsp";
    }

}
