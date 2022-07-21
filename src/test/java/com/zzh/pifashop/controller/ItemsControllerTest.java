package com.zzh.pifashop.controller;

import com.zzh.pifashop.PifaShopApplication;
import javafx.application.Application;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
class ItemsControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public String responseString(String url) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(url)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void itemList() throws Exception {
        setUp();
//        String json = "{}";
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/itemList")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    @Test
    void itemDetial() throws Exception {
        setUp();
//        String json = "{}";
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/itemDetial")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    @Test
    @Transactional
    @Rollback
    void additem() throws Exception {
        setUp();
//        String json = "{}";
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/addItem?name=果汁&price=10&url=src/main/resources/static/椰汁.png")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    @Test
    @Transactional
    @Rollback
    void takedown() throws Exception {
        setUp();
//        String json = "{}";
        String responseString = mockMvc.perform(MockMvcRequestBuilders.post("/itemList")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }
}