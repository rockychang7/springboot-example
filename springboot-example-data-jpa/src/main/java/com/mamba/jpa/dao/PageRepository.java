package com.mamba.jpa.dao;

import com.mamba.jpa.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/11 12:11
 * @description 分页
 */
public interface PageRepository extends PagingAndSortingRepository<User, Integer> {


}