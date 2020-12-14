package com.jpeony.hystrix.controller;

import com.jpeony.hystrix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * -- @RestController这个注解等价于spring mvc用法中的@Controller+@ResponseBody
 *
 * @author yihonglei
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户订单信息
     */
    @RequestMapping(value = "/queryOrderInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryOrderInfo() {

        return userService.queryOrderInfo();
    }
}