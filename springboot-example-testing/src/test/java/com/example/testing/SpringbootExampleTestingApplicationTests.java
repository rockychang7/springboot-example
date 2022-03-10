package com.example.testing;

import com.mamba.testing.SpringbootExampleTestingApplication;
import com.mamba.testing.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//classes配置基于什么上下文来启动，可以配置多个源,或者单独加载某个类
@SpringBootTest(classes = SpringbootExampleTestingApplication.class, args = "--app.id=001")
@AutoConfigureMockMvc
class SpringbootExampleTestingApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void demo1() {
        System.out.println(userService.login("123456", "joe"));
    }


    /**
     * 可以指定参数
     *
     * @param args
     */
    @Test
    public void demo2(@Autowired ApplicationArguments args) {
        assertThat(args.getOptionNames()).containsOnly("app.id");
        assertThat(args.getOptionValues("app.id")).containsOnly("001");
    }

    /**
     * 测试Controller
     */
    @Test
    public void demo3(@Autowired MockMvc mvc) throws Exception {
        mvc.perform(get("/user/test001")).andExpect(status().isOk()).andExpect(content().string("test001 Joe"));
    }


}
