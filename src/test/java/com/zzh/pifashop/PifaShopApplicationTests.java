package com.zzh.pifashop;

import com.alibaba.fastjson.JSON;
import com.zzh.pifashop.domain.Items;
import com.zzh.pifashop.mapper.IItemsMapper;
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


}
