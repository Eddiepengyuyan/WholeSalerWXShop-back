package com.zzh.pifashop.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
public class OrderDetial {
    @TableId(value = "order_detialid",type = IdType.AUTO)
    private Integer orderDetialid;
    // TODO: 2022/7/27 看看这个insert的时候能不能为null 实在不行等于0也行
    @TableField(insertStrategy = FieldStrategy.IGNORED)
    private long orderNum;
    private int itemid;
//    商品数量
    private int itemNum;
//    这个商品总价
    private double tempPrice;
    private int isSure;
}
