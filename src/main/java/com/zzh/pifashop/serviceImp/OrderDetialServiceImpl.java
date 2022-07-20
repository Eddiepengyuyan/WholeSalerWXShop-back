package com.zzh.pifashop.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.pifashop.domain.OrderDetial;
import com.zzh.pifashop.mapper.IOrderDetailMapper;
import com.zzh.pifashop.service.IOrderDetailService;
import org.springframework.stereotype.Service;

@Service("orderDetialService")
public class OrderDetialServiceImpl extends ServiceImpl<IOrderDetailMapper, OrderDetial> implements IOrderDetailService {
}
