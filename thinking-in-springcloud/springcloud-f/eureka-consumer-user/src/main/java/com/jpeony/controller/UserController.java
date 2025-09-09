package com.jpeony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * -- @RestController这个注解等价于spring mvc用法中的@Controller+@ResponseBody
 *
 * @author yihonglei
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/queryUserInfo", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryUserInfo() {
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://EUREKA-PROVIDER-ORDER/order/queryOrderInfo", String.class);

        return responseEntity.getBody();
    }
}