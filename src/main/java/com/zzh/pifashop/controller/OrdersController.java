package com.zzh.pifashop.controller;

import com.alibaba.fastjson.JSON;
import com.zzh.pifashop.domain.Orders;
import com.zzh.pifashop.service.IOrderDetailService;
import com.zzh.pifashop.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableAutoConfiguration
public class OrdersController {

    @Autowired
    IOrdersService ordersService;


    @RequestMapping("/addOrder")
    public String addOrder(HttpServletRequest request,
                           @RequestParam int userid,
                           @RequestParam double price,
                           @RequestParam String address,
                           @RequestParam String phoneNumber
    ){
        Orders orders = new Orders(userid);
        orders.setUserid(userid);
        return JSON.toJSONString(userid);
    }



}
