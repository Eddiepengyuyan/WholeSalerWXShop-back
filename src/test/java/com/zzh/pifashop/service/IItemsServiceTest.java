package com.zzh.pifashop.service;

import com.zzh.pifashop.domain.Items;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IItemsServiceTest {

    @Autowired
    IItemsService iItemsService;

    @Test
    @Transactional
    @Rollback
    void additem() {
        Items items = new Items("果汁", 10, "src/main/resources/static/椰汁.png");
        iItemsService.save(items);

    }

    @Test
    @Transactional
    @Rollback
    void updateState() {

    }
}