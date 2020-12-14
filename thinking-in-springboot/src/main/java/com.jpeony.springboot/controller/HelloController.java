package com.jpeony.springboot.controller;

import com.jpeony.springboot.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot的@RestController注解等价于Spring MVC的@Controller+@ResponseBody
 *
 * @author yihonglei
 */
@RestController
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam("name") String name) {

        return helloService.sayHello(name);
    }

}
