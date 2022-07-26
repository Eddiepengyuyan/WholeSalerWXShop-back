package com.zzh.pifashop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Users {
    @TableId(value = "userid",type = IdType.AUTO)
    private Integer userid;
    private String nickName;
    private String openid;
    private String avatarUrl;
    private int gender;
//    是否是管理员
    private int is_admin;
//    注册时间
    private String signTime;
}
