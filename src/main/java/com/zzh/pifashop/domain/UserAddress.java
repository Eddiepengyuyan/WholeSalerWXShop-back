package com.zzh.pifashop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    @TableId(value = "user_addressid",type = IdType.AUTO)
    private Integer userAddressid;
    private int userid;
    private String nickname;
    private String phone;
    private String address;
}
