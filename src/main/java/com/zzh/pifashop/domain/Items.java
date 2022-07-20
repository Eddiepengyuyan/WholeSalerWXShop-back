package com.zzh.pifashop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    //酒水饮料的属性
//    @TableId(value = "itemid",type = IdType.AUTO)//在自增主键的变量加上即可
    private int itemid;
    private String name;
    private double price;
    private int state;
    private String url;

    public Items(String name, double price, String url) {
        this.name = name;
        this.price = price;
        this.state = 0;
        this.url = url;
    }

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
