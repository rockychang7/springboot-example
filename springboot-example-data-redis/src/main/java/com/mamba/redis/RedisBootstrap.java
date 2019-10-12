package com.mamba.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/12 15:23
 * @description Redis的相关操作
 */

@Controller
public class RedisBootstrap {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    //string(字符串)
    public void addOrUpdate(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }


    public Long incrementByCount(String key, Long count) {
        return stringRedisTemplate.opsForValue().increment(key, count);
    }

    public Long increment(String key) {
        return incrementByCount(key, 1L);
    }

    public Boolean isExist(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    public Boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return stringRedisTemplate.expire(key, timeout, timeUnit);
    }

    //list(双向链表)
    public void leftPush(String key, String value) {
        stringRedisTemplate.opsForList().leftPush(key, value);
    }


    public void rightPush(String key, String value) {
        stringRedisTemplate.opsForList().rightPush(key, value);
    }


    public void leftPushAll(String key, String... values) {
        stringRedisTemplate.opsForList().leftPushAll(key, values);
    }


    public void rightPushAll(String key, String... values) {
        stringRedisTemplate.opsForList().rightPushAll(key, values);
    }

    public String leftPop(String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    public String rightPop(String key) {
        return stringRedisTemplate.opsForList().rightPop(key);
    }

    public void updateListValue(String key, long index, String value) {
        stringRedisTemplate.opsForList().set(key, index, value);
    }

    public void remove(String key, long index, Object value) {
        stringRedisTemplate.opsForList().remove(key, index, value);
    }

    //hash
    public Object getHashValue(String identify, Object key) {
        return stringRedisTemplate.opsForHash().get(identify, key);
    }

    public void setHashValue(String identify, Object key, Object value) {
        stringRedisTemplate.opsForHash().put(identify, key, value);
    }
}