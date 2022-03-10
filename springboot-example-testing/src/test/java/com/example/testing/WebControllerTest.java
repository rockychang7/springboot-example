package com.example.testing;

import com.mamba.testing.Controller.UserController;
import com.mamba.testing.SpringbootExampleTestingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author JoeBig7
 * @date 2022/3/10 18:51:07
 * @descrition 只测试Controller层
 */
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = SpringbootExampleTestingApplication.class)
public class WebControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void demo1() throws Exception{
        mvc.perform(get("/user/123")).andExpect(status().isOk())
                .andExpect(content().string("123 Joe"));
    }

}
