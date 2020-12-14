package com.jpeony.springboot.service.impl;

import com.jpeony.springboot.dao.CatDao;
import com.jpeony.springboot.dao.CatRepository;
import com.jpeony.springboot.domain.Cat;
import com.jpeony.springboot.service.ICatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * cat service:
 * save，update，delete方法需要绑定事务。
 * 使用@Transactional进行事务绑定。
 *
 * @author yihonglei
 */
@Service
public class CatServiceImpl implements ICatService {
    @Resource
    private CatRepository catRepository;
    @Resource
    private CatDao catDao;

    /**
     * 保存数据
     */
    @Transactional
    @Override
    public void save(Cat cat) {

        catRepository.save(cat);
    }

    /**
     * 删除数据
     */
    @Transactional
    @Override
    public void delete(int id) {

        // 1.5.7.RELEASE
        // catRepository.delete(id)

        // 2.0.8.2.0.8.RELEASE
        catRepository.deleteById(id);
    }

    /**
     * 查询数据
     */
    @Override
    public Iterable<Cat> getAll() {

        return catRepository.findAll();
    }

    /**
     * 根据name查询
     */
    public Cat queryByCatName(String catName) {

        return catDao.queryByCatName(catName);
    }
}
