package com.jpeony.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RequestMapping测试
 *
 * @author yihonglei
 */
@Controller
@RequestMapping("/testRM")
public class RequestMappingController {
    private static final String SUCCESS = "success";
    /*A.==============RequestMapping映射类处和方法处================*/

    /**
     * 1.通过RequestMapping注解映射请求URL
     * 2.返回值通过InternalResourceViewResolver解析到实际的视图，解析方式：
     * 前缀(prefix)+返回值(returnVal)+后缀(suffix)得到视图，通过转发器转发操作
     * 比如这个实例解析的实际视图路径如下：
     * /WEB-INF/views/success.jsp
     * 3.RequestMapping映射类
     * 提供初步的请求映射信息，相对于WEB应用的根目录。
     * 4.RequestMapping映射方法
     * 提供进一步的细分映射信息，相对于类定义的URL。
     * 如果在类上没有@RequestMapping，则访问地址为方法指定的testRequestMapping
     * 如果在类上有@RequestMapping，则访问地址为类上的映射地址加上方法的访问地址，
     * 即为testRM/testRequestMapping
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping!");
        return SUCCESS;
    }

    /*B.==============RequestMapping指定请求方式(常用)==============*/

    /**
     * RequestMapping的value属性指定请求URL;
     * RequestMapping的method属性指定接受的请求方式，如果发送请求的方式与指定接受请求的方式不符，报错;
     * 请求方式包含:GET,POST请求,默认使用GET请求
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.GET)
    public String testMethod() {
        System.out.println("Test method");
        return SUCCESS;
    }
    /*C.===============PathVariable指定映射值 =====================*/

    /**
     * @param username
     * @PathVariable是spring3.0新增属性，用于指定访问时传入参数，映射到方法的参数 注意：/testPathVariable/{username}的username与@PathVariable("username")的username名字
     * 一定要一致，否则传入时{username}不知道映射到哪里去
     */
    @RequestMapping("/testPathVariable/{username}")
    public String testPathVariable(@PathVariable("username") String username) {
        System.out.println("Test path variable: " + username);
        return SUCCESS;
    }
}
