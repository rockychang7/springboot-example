package com.mamba.mongo.Repository;

import com.mamba.mongo.model.Custom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/19 16:10
 */
public interface CustomRepository extends MongoRepository<Custom, Long> {

    public List<Custom> findByNameLike(String name);

    public Custom findByIdEquals(Long Id);

}