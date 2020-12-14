package com.jpeony.springboot.controller;

import com.jpeony.springboot.domain.Cat;
import com.jpeony.springboot.service.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot整合jdbc
 *
 * @author yihonglei
 */
@RestController
@RequestMapping("/cat")
public class JdbcController {
    @Autowired
    private ICatService catService;

    /**
     * jdbcTemplate查询数据使用
     */
    @RequestMapping("/queryByCatName")
    public Cat queryByCatName(String catName) {

        return catService.queryByCatName(catName);
    }
}
