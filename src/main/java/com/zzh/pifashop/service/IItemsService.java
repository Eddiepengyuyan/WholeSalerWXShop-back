package com.zzh.pifashop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzh.pifashop.domain.Items;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("itemService")
public interface IItemsService extends IService<Items> {
//    下架商品，即更新状态为-1
    void updateState(int itemid);


////    items的所有方法
////    新加商品
//    void addItem (String Name,double price,int state);
////    获取所有商品
//    List<Items> getAllItems();
////    获取特定商品信息
//    Items findItemById(int id);
////    修改商品信息
//    void setName(int id);
//    void setPrice(int id);
}
