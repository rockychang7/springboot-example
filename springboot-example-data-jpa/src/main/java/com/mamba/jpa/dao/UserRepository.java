package com.mamba.jpa.dao;

import com.mamba.jpa.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    List<User> findByUsername(String username);
}
