package com.zzh.pifashop.domain;

import lombok.Data;

@Data
public class OrderDetial {
    private int orderDetialid;
    private int orderid;
    private int itemid;
//    商品数量
    private int itemNum;
//    这个商品总价
    private int tempPrice;
}
