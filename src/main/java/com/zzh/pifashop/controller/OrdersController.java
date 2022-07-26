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

/**
 * @Title: 订单类的controller
 * @Description:
 * @Author: 22505
 * @Date: 2022/7/26
 * @Version: 1.0
*/
@RestController
@EnableAutoConfiguration
public class OrdersController {

    @Autowired
    IOrdersService ordersService;
    @Autowired
    IOrderDetailService orderDetailService;
    @Autowired
    IUserAddressService userAddressService;

    /**
     * 获取一个用户未完成的订单
     * @param request
     * @param userid
     * @return
     */
    @RequestMapping("/unfinishOrderList")
    public String unfinishOrderList(HttpServletRequest request,
                                    @RequestParam int userid){
        QueryWrapper<Orders> qw = new QueryWrapper<>();
        qw.eq("userid",userid).eq("state",0);
        List<Orders> list = ordersService.list(qw);
        return JSON.toJSONString(list);
    }

    /**
     * 获取一个用户的所有订单
     * @param request
     * @param userid
     * @return
     */
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
     * @return
     */
    @RequestMapping("/submitOrder")
    public String submitOrder(HttpServletRequest request,
                                @RequestParam int useraddressid,
                                @RequestParam int userid,
                                @RequestParam double totalprice){
//        1.更新orderDetial的信息
        QueryWrapper<UserAddress> qw = new QueryWrapper<>();
        qw.eq("user_addressid",useraddressid).select("phone");
//        获取手机号后四位
        String phone = userAddressService.list(qw).get(0).getPhone().substring(7);
//        生成订单号。
        long orderNum = newOrderNum(phone);

//        List<OrderDetial> ods = orderDetailService.list(qw);
        UpdateWrapper<OrderDetial> uwod = new UpdateWrapper<>();
        uwod.eq("is_sure",0).set("order_num",orderNum).set("is_sure",1);
        orderDetailService.update(uwod);
//        2.然后更新order的信息
        Orders order = new Orders();
        order.setOrderNum(orderNum);order.setUserAddressid(useraddressid);
        order.setUserid(userid);order.setTotalPrice(totalprice);
        order.setTime(nowDateTime());
        ordersService.save(order);
        return "200";
    }

    
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

    /**
     * 添加或修改一个订单项(orderDetial)
     * @param request
     * @param itemid
     * @param itemNum
     * @param tempPrice
     * @return
     */
    @RequestMapping("/addOrderItem")
    public String addOrderItem(HttpServletRequest request,
                               @RequestParam(required =false,defaultValue = "-1") int orderDetialid,
                               @RequestParam int itemid,
                               @RequestParam int itemNum,
                               @RequestParam double tempPrice){
        UpdateWrapper<OrderDetial> uw = new UpdateWrapper<>();
        OrderDetial od = new OrderDetial();
        od.setItemid(itemid);od.setItemNum(itemNum);od.setTempPrice(tempPrice);
        if (orderDetialid == -1 ){
            orderDetailService.save(od);
        }else {
            uw.eq("order_detialid",orderDetialid);
//            uw.set("itemid",itemid).set("item_num",itemNum).set("temp_price",tempPrice);
            orderDetailService.saveOrUpdate(od,uw);
        }
        return "200";
    }



    /**
     * 获取所有未完成的订单列表
     * @return
     */
    @RequestMapping("/getUnfinishOrderList")
    public String getUnfinishOrderList(){
        QueryWrapper<Orders> qw = new QueryWrapper<>();
        qw.eq("state",0);
        List<Orders> ordersList = ordersService.list(qw);
        return JSON.toJSONString(ordersList);
    }

    /**
     *  获取所有订单列表
     * @return
     */
    @RequestMapping("/getAllOrderList")
    public String getAllOrderList(){
        List<Orders> list = ordersService.list();
        return JSON.toJSONString(list);
    }





    /**
     * 生成订单号的算法
     */
    private long newOrderNum(String phonetail){
        SimpleDateFormat sdfTime = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//        System.out.println("时间戳："+sdfTime.format(new Date()));
        String time = sdfTime.format(new Date());
        time = time.replaceAll("[[\\s-:punct:]]", "");
        Random rm = new Random();
        int random = (int)(rm.nextDouble()*Math.pow(10,rm.nextInt(5)+5)%1000);
        String temp = time + random + phonetail;
        long orderNum = Long.parseLong(temp) ;
        return orderNum;
    }

    /**
     * 获取当前时间的算法
     * @return
     */
    private String nowDateTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        return time;
    }

}
