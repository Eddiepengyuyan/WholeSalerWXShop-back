package com.zzh.pifashop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.pifashop.domain.Orders;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 订单数据库
 * @author 22505
 */
@Repository
public interface IOrdersMapper extends BaseMapper<Orders> {

    @Update("update Orders set state = -1 where itemid=#{itemid}")
    void completeOrder(int orderid);
}
