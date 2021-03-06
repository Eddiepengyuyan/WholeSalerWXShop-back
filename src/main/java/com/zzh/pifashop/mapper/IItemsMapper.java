package com.zzh.pifashop.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzh.pifashop.domain.Items;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 商品的数据连接层
 * @author 22505
 */
@Repository
public interface IItemsMapper extends BaseMapper<Items> {

    /**
     * 逻辑删除商品
     * @param itemid
     */
    @Update("update Items set state = -1 where itemid=#{itemid}")
    void updateState(int itemid);
}
