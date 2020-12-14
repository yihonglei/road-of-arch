package com.jpeony.springboot.dao;

import com.jpeony.springboot.domain.Cat;
import org.springframework.data.repository.CrudRepository;

/**
 * curd操作
 *
 * @author yihonglei
 */
public interface CatRepository extends CrudRepository<Cat, Integer> {
}
