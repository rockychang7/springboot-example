package com.mamba.mongo;

import com.mamba.mongo.Repository.CustomRepository;
import com.mamba.mongo.model.Custom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/19 16:21
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoRepositoryTest {

    @Autowired
    private CustomRepository customRepository;

    @Test
    public void testInsert() {
        Custom custom = new Custom(10001L, "jack", new Date(), "shanghai");
        customRepository.insert(custom);
    }


    @Test
    public void testFindByName() {
        List<Custom> customList = customRepository.findByNameLike("jack");
        System.out.println(customList);
    }

    /**
     * 更新/保存
     */
    @Test
    public void testUpdate() {
        Custom custom = new Custom(10001L, "jack2", new Date(), "beijing");
        customRepository.save(custom);
    }


    /**
     * 更新/保存
     */
    @Test
    public void find() {
        List<Custom> customList = customRepository.findAll(Sort.by("name"));
        System.out.println(customList);
    }


}