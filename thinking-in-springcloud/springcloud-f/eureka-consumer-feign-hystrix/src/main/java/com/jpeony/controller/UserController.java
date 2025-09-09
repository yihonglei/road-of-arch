package com.jpeony.controller;

import com.jpeony.order.OrderApi;
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
    private OrderApi orderApi;

    @RequestMapping(value = "/queryUserInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryUserInfo() {

        return orderApi.queryOrdersByUserId();
    }
}