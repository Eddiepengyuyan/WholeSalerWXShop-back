package com.zzh.pifashop;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzh.pifashop.domain.Items;
import com.zzh.pifashop.domain.Orders;
import com.zzh.pifashop.mapper.IItemsMapper;
import com.zzh.pifashop.service.IOrdersService;
import com.zzh.pifashop.serviceImp.ItemsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
