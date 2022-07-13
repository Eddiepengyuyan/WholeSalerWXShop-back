package com.zzh.pifashop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Items {
    //酒水饮料的属性
//    @TableId(value = "itemid",type = IdType.AUTO)//在自增主键的变量加上即可
    private int itemid;
    private String name;
    private double price;
    private int state;

//    //空构造方法
//    public Items(){}
//
//    public int getId() {
//        return id;
//    }
//
////    public void setId(int id) {
////        this.id = id;
////    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Items{"+
//                "id="+id+
//                "name='"+ name+"\'"+
//                "price="+price+
//                "}";
//    }
}
