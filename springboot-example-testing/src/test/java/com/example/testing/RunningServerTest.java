package com.example.testing;

import com.mamba.testing.SpringbootExampleTestingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author JoeBig7
 * @date 2022/3/10 18:52:33
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = SpringbootExampleTestingApplication.class)
public class RunningServerTest {


    /*
       启动一个完整地server
     */
    @Test
    void demo1(@Autowired TestRestTemplate restTemplate) {
        String body = restTemplate.getForObject("/user/123", String.class);
        assertThat(body).isEqualTo("123 Joe");
    }
}
