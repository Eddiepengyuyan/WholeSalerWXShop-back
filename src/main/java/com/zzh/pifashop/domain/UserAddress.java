package com.zzh.pifashop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    private int userAddressid;
    private int userid;
    private String nickname;
    private String phone;
    private String address;
}
