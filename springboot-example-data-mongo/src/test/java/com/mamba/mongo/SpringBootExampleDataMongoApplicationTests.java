package com.mamba.mongo;

import com.mamba.mongo.bootstrap.MongoService;
import com.mamba.mongo.bootstrap.MongoTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootExampleDataMongoApplicationTests {

    @Autowired
    private MongoTemplateService mongoTemplateService;
    @Autowired
    private MongoService mongoService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAdd() {
        mongoService.insertOne();
    }

    @Test
    public void testAddMany() {
        mongoService.insertMany();
    }

    @Test
    public void testUpdate() {
        mongoService.update();
    }

    @Test
    public void testFind() {
        mongoService.find();
    }

    @Test
    public void testDelete() {
        mongoService.delete();
    }


    @Test
    public void testTemplateAdd() {
        mongoTemplateService.insertOne();
    }

    @Test
    public void testTemplateAddMany() {
        mongoTemplateService.insertMany();
    }

    @Test
    public void testTemplateSave() {
        mongoTemplateService.save();
    }

    @Test
    public void testTemplateUpdate() {
        mongoTemplateService.update();
    }

    @Test
    public void testTemplateFind() {
        mongoTemplateService.find();
    }

    @Test
    public void testTemplateFindByCondition() {
        mongoTemplateService.findByCondition();
    }


    @Test
    public void testTemplateDelete() {
        mongoTemplateService.delete();
    }



}
