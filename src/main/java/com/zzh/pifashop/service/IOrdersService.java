package com.zzh.pifashop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.zzh.pifashop.domain.Orders;
import com.zzh.pifashop.mapper.IOrdersMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("orderService")
public interface IOrdersService extends IService<Orders> {

    void completeOrder(int orderid);

//    //订单类的所有方法
//    void addOrder();
//    List<Orders> getAllOrders(int id);
////    通过顾客id获取订单id
//    int findOrderByCusId(int customId);
////    通过订单id获取订单
//    Orders findOrderById(int orderId);
////    设置订单属性
//    void setStatu(int statu);
//    void setItemNumbers(int itemNumbers);
//    void setAddress(String address);
//    void setPhone(String phone);
}
