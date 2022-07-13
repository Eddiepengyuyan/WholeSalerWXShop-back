package com.zzh.pifashop.domain;

import lombok.Data;

@Data
public class Orders {
    //订单属性
    //订单id
    private int orderid;
    //顾客id
    private int userid;
//    商品总价
    private double totalPrice ;
//    订单状态
    private int state;
    private String address;
    private String phoneNumber;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getCustomerid() {
//        return customerid;
//    }
//
//    public void setCustomerid(int customerid) {
//        this.customerid = customerid;
//    }
//
//    public int getItemid() {
//        return itemid;
//    }
//
//    public void setItemid(int itemid) {
//        this.itemid = itemid;
//    }
//
//    public int getItemNumber() {
//        return itemNumber;
//    }
//
//    public void setItemNumber(int itemNumber) {
//        this.itemNumber = itemNumber;
//    }
//
//    public int getState() {
//        return state;
//    }
//
//    public void setState(int state) {
//        this.state = state;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    @Override
//    public String toString() {
//        return "Orders{" +
//                "id=" + id +
//                ", customerid=" + customerid +
//                ", itemid=" + itemid +
//                ", itemNumber=" + itemNumber +
//                ", state=" + state +
//                ", address='" + address + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
//    }
}
