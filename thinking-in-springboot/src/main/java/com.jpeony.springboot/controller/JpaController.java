package com.jpeony.springboot.controller;

import com.jpeony.springboot.domain.Cat;
import com.jpeony.springboot.service.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot整合jpa
 *
 * @author yihonglei
 */
@RestController
@RequestMapping("/cat")
public class JpaController {
    @Autowired
    private ICatService catService;

    /**
     * 保存数据
     */
    @RequestMapping("/save")
    public String save() {
        Cat cat = new Cat();
        //cat.setId(1); // 通过MySQL主键自增长策略生成
        cat.setCatName("hello kitty");
        cat.setCatAge(26);
        catService.save(cat);

        return "save ok";
    }

    /**
     * 删除数据
     */
    @RequestMapping("/delete")
    public String delete() {
        // 这里只删了id为1的
        catService.delete(1);

        return "delete ok";
    }

    /**
     * 查询数据
     */
    @RequestMapping("/getAll")
    public Iterable<Cat> getAll() {

        return catService.getAll();
    }
}
