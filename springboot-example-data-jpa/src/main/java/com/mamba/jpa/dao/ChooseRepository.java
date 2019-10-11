package com.mamba.jpa.dao;

import com.mamba.jpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/11 12:47
 * @description 选择需要暴露的方法  这样子的话继承的子类只会拥有暴露的两个方法
 */
@NoRepositoryBean
public interface ChooseRepository extends CrudRepository<User, Integer> {

    User save(User user);

    Optional<User> findById(Integer id);
}