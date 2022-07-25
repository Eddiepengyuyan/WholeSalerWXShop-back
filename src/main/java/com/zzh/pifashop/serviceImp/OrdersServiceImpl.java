package com.zzh.pifashop.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.pifashop.domain.Orders;
import com.zzh.pifashop.mapper.IOrdersMapper;
import com.zzh.pifashop.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrdersServiceImpl extends ServiceImpl<IOrdersMapper, Orders> implements IOrdersService {
    @Autowired
    IOrdersMapper mapper;

    @Override
    public void completeOrder(int orderid) {
        mapper.completeOrder(orderid);
    }
}
