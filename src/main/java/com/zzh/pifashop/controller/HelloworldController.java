package com.zzh.pifashop.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloworldController {

    @RequestMapping("/index")
    public String helloworldController(){
        return "Hello world!";
    }

}
