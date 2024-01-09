package com.mamba.jpa;

import com.mamba.jpa.dao.CustomRepository;
import com.mamba.jpa.dao.PageRepository;
import com.mamba.jpa.dao.UserRepository;
import com.mamba.jpa.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
public class SpringBootExampleDataJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private CustomRepository customRepository;

    @Test
    public void testSave() {
        userRepository.save(new User("james", 24));
    }


    @Test
    public void testGet() {
        List<User> userList = userRepository.findByUsername("joe");

        System.out.println(userList);
    }

    @Test
    public void testGetAll() {
        Iterable<User> all = userRepository.findAll();

        all.forEach(u -> {
            System.out.println(u);
        });
    }

    @Test
    public void testGetCount() {
        long count = userRepository.count();
        System.out.println("总人数==" + count);
    }

    @Test
    public void testPage() {

        //分页查询并且以username进行排序
        Page<User> all = pageRepository.findAll(PageRequest.of(1, 2, Sort.by(Sort.Order.by("username"))));

//        Page<User> all = pageRepository.findAll(new QPageRequest(1,2));

        all.get().forEach(u -> System.out.println(u));

    }

    @Test
    public void testCustomGet() {
        List<User> userList = customRepository.findByUsername("joe");
        System.out.println(userList);
    }


}
