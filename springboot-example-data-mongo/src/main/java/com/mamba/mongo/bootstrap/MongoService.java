package com.mamba.mongo.bootstrap;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertOneOptions;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/19 11:32
 */
@Service
public class MongoService {



    @Autowired
    private MongoDbFactory mongoDbFactory;

    public MongoDatabase getMongoDatabase() {
        return mongoDbFactory.getDb("test");
    }


    public void insertOne() {
        MongoDatabase db = getMongoDatabase();

        Document document = new Document();
        document.put("name", "joe2");
        document.put("age", 20);
        document.put("address", "earth2");
        db.getCollection("user").insertOne(document, new InsertOneOptions().bypassDocumentValidation(false));
    }

    public void insertMany() {
        MongoDatabase db = getMongoDatabase();
        Document document = new Document();
        document.put("name", "jack");
        document.put("age", 20);
        document.put("address", "moon");

        Document document2 = new Document();
        document2.put("name", "rose");
        document2.put("age", 22);
        document2.put("address", "Mars");
        List<Document> list = new ArrayList<>();
        list.add(document);
        list.add(document2);
        db.getCollection("user").insertMany(list);

    }

    public void update() {
        MongoDatabase db = getMongoDatabase();
        Document filter = new Document();
        filter.put("name", "rose");
        Document update = new Document();
        Document content = new Document();
        content.put("address", "beijing");
        update.put("$set", content);
        db.getCollection("user").updateOne(filter, update);
    }


    public void find() {
        MongoDatabase db = getMongoDatabase();
        Document filter = new Document();
        filter.put("age", 22);
        FindIterable<Document> result = db.getCollection("user").find(filter);

        MongoCursor<Document> iterator = result.iterator();

        List<Document> list = new ArrayList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        System.out.println(list.toString());
    }


    public void delete() {
        MongoDatabase db = getMongoDatabase();
        Document filter = new Document();
        filter.put("name", "jerry2");
        db.getCollection("user").deleteMany(filter);
    }



}