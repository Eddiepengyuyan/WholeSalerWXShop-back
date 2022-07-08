package com.zzh.pifashop.service;

import com.zzh.pifashop.domain.Items;

import java.util.List;

public interface IItemsService {
//    items的所有方法
    //新加商品
    void addItem (String Name,double price);
    //获取所有商品
    List<Items> getAllItems();
    //获取特定商品信息
    Items findItemById(int id);
    //修改商品信息
    void setName(int id);
    void setPrice(int id);
}
