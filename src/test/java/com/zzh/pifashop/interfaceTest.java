package com.zzh.pifashop;

import com.zzh.pifashop.controller.ItemsController;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.beans.Transient;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest     //获取启动类，加载配置，寻找主配置启动类（被 @SpringBootApplication 注解的）
@RunWith(SpringRunner.class)    //让JUnit运行Spring的测试环境,获得Spring环境的上下文的支持
@AutoConfigureMockMvc       //用于自动配置MockMvc,配置后MockMvc类可以直接注入,相当于new MockMvc
class interfaceTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @BeforeEach     //初始化方法 ,对于每一个测试方法都要执行一次
    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new ItemsController()).build();   //这种写法总是会出现装配的类为空的现象。
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        System.out.println("初始化mock模块");
    }
    @Test
    @Transactional      //开启事务功能
    @Rollback()       //事务回滚,默认是true
    void itemListTest() throws Exception {
        setUp();
        String responseString = mvc.perform(MockMvcRequestBuilders.post("/itemList")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串;
        System.out.println("获取结果为：" + responseString);
    }
}
