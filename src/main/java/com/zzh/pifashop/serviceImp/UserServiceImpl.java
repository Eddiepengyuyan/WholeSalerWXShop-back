package com.zzh.pifashop.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.pifashop.domain.Users;
import com.zzh.pifashop.mapper.IUsersMapper;
import com.zzh.pifashop.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<IUsersMapper, Users> implements IUserService {
}
