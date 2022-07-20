package com.zzh.pifashop.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.pifashop.domain.Orders;
import com.zzh.pifashop.mapper.IOrdersMapper;
import com.zzh.pifashop.service.IOrdersService;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrdersServiceImpl extends ServiceImpl<IOrdersMapper, Orders> implements IOrdersService {
}
