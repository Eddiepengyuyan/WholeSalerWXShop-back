package com.zzh.pifashop.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class OrdersControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setup(){
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
    void orderList() throws Exception {
        setup();
        String responseString = responseString("/orderList?userid=1");
        System.out.println(responseString);
    }
}