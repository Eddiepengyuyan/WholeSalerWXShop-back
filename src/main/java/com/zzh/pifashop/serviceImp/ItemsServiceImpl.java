package com.zzh.pifashop.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.pifashop.domain.Items;
import com.zzh.pifashop.mapper.IItemsMapper;
import com.zzh.pifashop.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemsServiceImpl extends ServiceImpl<IItemsMapper, Items> implements IItemsService {
    @Autowired
    IItemsMapper mapper;
    @Override
    public void updateState(int itemid) {
        mapper.updateState(itemid);
    }
//
//    @Resource
//    private IItemsMapper iItemsMapper;
//
//    public void addItem(String Name, double price,int state) {
//        Items i = new Items();
//        i.setName(Name);i.setPrice(price);i.setState(state);
//        iItemsMapper.insert(i);
//    }
//
//    public List<Items> getAllItems() {
//        List<Items> is = iItemsMapper.selectList(null);
//        return is;
//    }
//
//    public Items findItemById(int id) {
//        return null;
//    }
//
//    public void setName(int id) {
//
//    }
//
//    public void setPrice(int id) {
//
//    }
}
