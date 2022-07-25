package com.zzh.pifashop;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zzh.pifashop.domain.Items;
import com.zzh.pifashop.domain.OrderDetial;
import com.zzh.pifashop.domain.Orders;
import com.zzh.pifashop.domain.UserAddress;
import com.zzh.pifashop.mapper.IItemsMapper;
import com.zzh.pifashop.service.IOrderDetailService;
import com.zzh.pifashop.service.IOrdersService;
import com.zzh.pifashop.service.IUserAddressService;
import com.zzh.pifashop.serviceImp.ItemsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PifaShopApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * Mapper测试
     */
    @Autowired
//    @Resource
    private IItemsMapper iItemsMapper;
    @Test
    void sqlLinkTest(){
        System.out.println(("----- selectAll method test ------"));
        List<Items> itemList = iItemsMapper.selectList(null);
//        Assert.assertEquals(5, itemList.size());
        itemList.forEach(System.out::println);
    }

    /**
     * Service测试
     */
    @Resource
    private ItemsServiceImpl itemsServiceImp;

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private IUserAddressService userAddressService;

    @Test
    void addItemTest(){

    }

    @Test
    void getAllItemsTest(){
        List<Items> items = itemsServiceImp.list(null);
        String json = JSON.toJSONString(items);
//        items.forEach(System.out::println);
        System.out.println(json);
    }

    @Test
    void orderList() {
        QueryWrapper<Orders> ordersQueryWrapper = new QueryWrapper<>();
        ordersQueryWrapper.eq("userid",2);
        List<Orders> list = ordersService.list(ordersQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
//    @Transactional
//    @Rollback
    void submitOrder(){
        QueryWrapper<UserAddress> qw = new QueryWrapper<>();
        qw.eq("user_addressid",1).select("phone");
        String phone = userAddressService.list(qw).get(0).getPhone().substring(7);
        System.out.println(phone);
        // TODO: 2022/7/26 写一个只返回phone的sql 
//        UpdateWrapper<OrderDetial> uw = new UpdateWrapper<>();
//        long orderNum = 220725231438865131L;
//        uw.eq("is_sure",0).set("order_num",orderNum).set("is_sure",1);
//        orderDetailService.update(uw);
//        List<OrderDetial> ods = orderDetailService.list();
//        ods.forEach(System.out::println);
    }
}
