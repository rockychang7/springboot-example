package com.mamba.jpa.dao;

import com.mamba.jpa.model.User;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/11 12:40
 * @description 定义自己的repository
 */
@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
public interface CustomRepository {
    List<User> findByUsername(String username);
}