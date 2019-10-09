package com.mamba.jdbctemplate.dao;

import com.mamba.jdbctemplate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/9 14:59
 * @description 使用JdbcTemplate操作数据库
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(User user) {
        jdbcTemplate.update("INSERT INTO user (username,age) VALUES (?,?)", user.getUsername(), user.getAge());
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM user  WHERE id=?", id);
    }


    public void update(User user) {
        jdbcTemplate.update("UPDATE user SET  username=?, age=?  WHERE id=?", user.getUsername(), user.getAge(), user.getId());
    }

    public User get(Integer id) {
        User user = jdbcTemplate.queryForObject("SELECT *FROM user WHERE id=?", new Object[]{id}, new RowMapper<User>() {
                    @Nullable
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user = new User();
                        user.setId(resultSet.getInt(1));
                        user.setUsername(resultSet.getString(2));
                        user.setAge(resultSet.getInt(3));
                        return user;
                    }
                }
        );

        return user;
    }


    public List<User> queryAllList() {

        List<User> userList = jdbcTemplate.query("SELECT *FROM user", new RowMapper<User>() {
            @Nullable
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setAge(resultSet.getInt(3));
                return user;
            }
        });

        return userList;
    }


}