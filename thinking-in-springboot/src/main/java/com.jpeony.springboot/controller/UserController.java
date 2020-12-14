package com.jpeony.springboot.controller;

import com.jpeony.springboot.vo.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @author yihonglei
 */
@RestController
public class UserController {

    @RequestMapping("/getUser")
    public UserVO getUser() {
        UserVO user = new UserVO();
        user.setId(1);
        user.setName("return json");
        return user;
    }
}
