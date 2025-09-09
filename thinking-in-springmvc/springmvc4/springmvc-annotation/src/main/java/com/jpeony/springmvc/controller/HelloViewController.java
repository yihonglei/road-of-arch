package com.jpeony.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yihonglei
 */
@Controller
@RequestMapping("/springView")
public class HelloViewController {

    @RequestMapping("/testView")
    public String testView(){
        //HelloView类首字母小写
        return "helloView";
    }

}
