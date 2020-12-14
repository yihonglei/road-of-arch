package com.jpeony.springboot.dao;

import com.jpeony.springboot.domain.Cat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 通过@Repository注解标注该类为持久化操作对象
 *
 * @author yihonglei
 */
@Repository
public class CatDao {
    // 通过@Resource注解引入JdbcTemplate对象
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 使用JdbcTemplate查询数据步骤:
     * 1、定义一个sql语句
     * 2、定义一个RowMapper
     * 3、执行查询方法
     */
    public Cat queryByCatName(String catName) {
        // 1、定义一个sql语句
        String querySQL = "select * from cat where cat_name = ?";
        // 2、定义一个RowMapper
        RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<>(Cat.class);
        // 3、执行查询方法
        Cat cat = jdbcTemplate.queryForObject(querySQL, new Object[]{catName}, rowMapper);

        return cat;
    }
}
