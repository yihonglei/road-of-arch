package com.jpeony.springmvc.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jpeony.springmvc.entity.Address;
import com.jpeony.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author yihonglei
 */
@Controller
@RequestMapping("/testRestful")
public class RestfulController {

    @RequestMapping("/list")
    public String queryList(Map<String, Object> map) {
        List<User> lists = new ArrayList<User>();
        // 这里没有建立持久层与数据库交互，硬编码两条数据做测试
        User user1 = new User();
        user1.setUsername("ONE");
        user1.setPassword("111111");
        Address address1 = new Address();
        address1.setProvince("aaaaaa");
        address1.setCity("bbbbbb");

        user1.setAddress(address1);
        //=========================
        User user2 = new User();
        user2.setUsername("TWO");
        user2.setPassword("222222");
        Address address2 = new Address();
        address2.setProvince("cccccc");
        address2.setCity("dddddd");

        user2.setAddress(address2);
        // User对象添加到List中
        lists.add(user1);
        lists.add(user2);

        // 将List封装到Map中
        map.put("users", lists);

        return "list";
    }

}
