package com.zzh.pifashop.controller;

import com.alibaba.fastjson.JSON;
import com.zzh.pifashop.domain.Items;
import com.zzh.pifashop.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class ItemsController {

    @Autowired
    IItemsService iItemsService;

    /**
     * 无参返回所有item的所有信息
     * @return
     */
    @RequestMapping("/itemList")
    public String itemList(){
        List<Items> items = iItemsService.list(null);
//        items.forEach(System.out::println);
        return JSON.toJSONString(items);
    }

    /**
     * 通过id返回一个item的所有信息
     * @param request
     * @param itemid
     * @return
     */
    @RequestMapping("/itemDetial")
    public String itemDetial(HttpServletRequest request,
                             @RequestParam int itemid){
        Items byId = iItemsService.getById(itemid);
        return JSON.toJSONString(byId);
    }

    /**
     * 上架商品
     * @param request
     * @param name
     * @param price
     * @param url
     * @return
     */
    @RequestMapping("/addItem")
    public String addItem(HttpServletRequest request,
                          @RequestParam String name,
                          @RequestParam double price,
                          @RequestParam String url){
        Items item = new Items(name, price, url);
        try {
            iItemsService.save(item);
        }catch (Exception e){
            return e.toString();
        }
        return "200";
    }

    /**
     * 下架商品
     * @param request
     * @param itemid
     * @return
     */
    @RequestMapping("/takedown")
    public String takedown(HttpServletRequest request,
                           @RequestParam int itemid){
        // TODO: 2022/7/19  构造器，完成sql
        iItemsService.updateState(itemid);
        return "200";
    }

}
