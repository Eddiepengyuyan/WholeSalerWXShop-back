package com.zzh.pifashop.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
public class OrderDetial {
    @TableId(value = "order_detialid",type = IdType.AUTO)
    private Integer orderDetialid;
    @TableField(insertStrategy = FieldStrategy.IGNORED)
    private long orderNum;
    private int itemid;
//    商品数量
    private int itemNum;
//    这个商品总价
    private double tempPrice;
    private int isSure;
}
