package com.mamba.mongo.bootstrap;

import com.mamba.mongo.model.User;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/19 12:37
 */
@Service
public class MongoTemplateService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertOne() {
        Document document = new Document();
        document.put("name", "james");
        document.put("age", 23);
        mongoTemplate.insert(document);
    }


    public void insertMany() {
        User user = new User("tony", 29);
        User user2 = new User("jackson", 12);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        mongoTemplate.insert(list, User.class);
    }

    public void update() {
        Query query = new Query().addCriteria(Criteria.where("name").is("tony"));
        Update update = new Update().set("address", "earth").set("age", 28);
        mongoTemplate.updateMulti(query, update, User.class);
    }

    public void find() {
        List<User> userList = mongoTemplate.findAll(User.class);
        System.out.println(userList);
    }

    public void findByCondition() {
        Query query = new Query().addCriteria(Criteria.where("name").is("tony"));
        List<User> userList = mongoTemplate.find(query, User.class);
        System.out.println(userList);
    }


    public void save() {
        User user = new User("tony", 31);
        mongoTemplate.save(user);
    }

    public void delete() {
        Query query = new Query().addCriteria(Criteria.where("name").is("tony"));
        mongoTemplate.remove(query, User.class);
    }

}