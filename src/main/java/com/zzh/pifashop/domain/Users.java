package com.zzh.pifashop.domain;

import lombok.Data;

@Data
public class Users {
    private int userid;
    private String nickName;
    private String openid;
    private String avatarUrl;
    private int gender;
//    是否是管理员
    private int is_admin;
//    注册时间
    private String signTime;
}
