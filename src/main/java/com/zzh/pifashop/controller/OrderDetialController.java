package com.zzh.pifashop.controller;

import com.zzh.pifashop.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@EnableAutoConfiguration
public class OrderDetialController {

    @Autowired
    IOrderDetailService orderDetailService;

    @RequestMapping("/addOrderDetial")
    public String addOrderDetial(HttpServletRequest request,
                                 @RequestParam int orderid){

        return "addOrderDetial";
    }
}
