package com.zzh.pifashop.controller;

import com.zzh.pifashop.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class OrderDetialController {

    @Autowired
    IOrderDetailService orderDetailService;

//    @RequestMapping("/addOrderDetial")
//    public String addOrderDetial(HttpServletRequest request,
//                                 @RequestParam int orderid){
//
//        return "addOrderDetial";
//    }
}
