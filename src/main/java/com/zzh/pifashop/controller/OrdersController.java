package com.zzh.pifashop.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zzh.pifashop.domain.OrderDetial;
import com.zzh.pifashop.domain.Orders;
import com.zzh.pifashop.domain.UserAddress;
import com.zzh.pifashop.service.IOrderDetailService;
import com.zzh.pifashop.service.IOrdersService;
import com.zzh.pifashop.service.IUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.JobSheets;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@EnableAutoConfiguration
public class OrdersController {

    @Autowired
    IOrdersService ordersService;
    @Autowired
    IOrderDetailService orderDetailService;
    @Autowired
    IUserAddressService userAddressService;


    @RequestMapping("/orderList")
    public String orderList(HttpServletRequest request,
                            @RequestParam int userid){
        QueryWrapper<Orders> ordersQueryWrapper = new QueryWrapper<>();
        ordersQueryWrapper.eq("userid",userid);
        List<Orders> list = ordersService.list(ordersQueryWrapper);
        return JSON.toJSONString(list);
    }
    

    /**
     * 新建一个订单
     * @param request
     * @param userid
     * @return
     */
//    @RequestMapping("/addOrder")
//    public String addOrder(HttpServletRequest request,
//                           @RequestParam int userid
//    ){
//        long tempON = newOrderNum();
//        long orderNum = tempON * 10000 + 5131;
//        Orders orders = new Orders(userid,orderNum);
//        orders.setUserid(userid);
//        return JSON.toJSONString(userid);
//    }

    /**
     * 提交订单时调用
     * @param request
     * @param useraddressid
     * @param userid
     * @param totalprice
     * @param time
     * @return
     */
    @RequestMapping("/submitOrder")
    public String submitOrder(HttpServletRequest request,
                                @RequestParam int useraddressid,
                                @RequestParam int userid,
                                @RequestParam double totalprice,
                                @RequestParam String time){
        QueryWrapper<UserAddress> qw = new QueryWrapper<>();
        qw.eq("user_addressid",useraddressid).select("phone");
        String phone = userAddressService.list(qw).toString();



//        生成订单号。
        long orderNum = newOrderNum();
        // TODO: 2022/7/21 获取用户手机号后4位

//        List<OrderDetial> ods = orderDetailService.list(qw);
        UpdateWrapper<OrderDetial> uw = new UpdateWrapper<>();
        uw.eq("is_sure",0).set("order_num",orderNum).set("is_sure",1);
        orderDetailService.update(uw);
        // TODO: 2022/7/21 完善完成订单的代码
        return "200";
    }

    // TODO: 2022/7/21 再确定一下订单流程 
    
//    @RequestMapping("/completeOrder")
//    public String completeOrder(HttpServletRequest request,
//                                @RequestParam int orderid){
//        Orders order = new Orders();
//        order = ordersService.getById(orderid);
//        order.setState(1);
//        long orderNum = newOrderNum();
//        order.setOrderNum(orderNum);
////        ordersService.completeOrder();
////        ordersService.updateById(order);
//        return "200";
//    }

    @RequestMapping("/addOrderItem")
    public String addOrderItem(HttpServletRequest request,
                               @RequestParam int itemid,
                               @RequestParam int itemNum,
                               @RequestParam double tempPrice){
        OrderDetial od = new OrderDetial();
        od.setItemid(itemid);od.setItemNum(itemNum);od.setTempPrice(tempPrice);
        orderDetailService.save(od);

        return "200";
    }


    /**
     * 生成订单号的算法
     */
    private long newOrderNum(){
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
//        System.out.println("时间戳："+sdfTime.format(new Date()));
        String time = sdfTime.format(new Date());
        time = time.replaceAll("[[\\s-:punct:]]", "");
        Random rm = new Random();
        int random = (int)(rm.nextDouble()*Math.pow(10,rm.nextInt(5)+5)%1000);
        String temp = time + random;
        long orderNum = Long.parseLong(temp) ;
        return orderNum;
    }

}
