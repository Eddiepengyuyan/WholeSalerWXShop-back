package com.zzh.pifashop.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.pifashop.domain.UserAddress;
import com.zzh.pifashop.mapper.IUserAddressMapper;
import com.zzh.pifashop.service.IUserAddressService;
import org.springframework.stereotype.Service;

@Service("userAddressService")
public class UserAddressServiceImpl extends ServiceImpl<IUserAddressMapper, UserAddress> implements IUserAddressService {
}
