package com.zzh.pifashop.controller;

import com.alibaba.fastjson.JSON;
import com.zzh.pifashop.domain.Items;
import com.zzh.pifashop.serviceImp.ItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ItemsController {

    @Autowired
    ItemsServiceImpl itemsServiceImpl;

    @RequestMapping("/itemList")
    public String itemList(){
        List<Items> items = itemsServiceImpl.list();

        return JSON.toJSONString(items);
    }
}
