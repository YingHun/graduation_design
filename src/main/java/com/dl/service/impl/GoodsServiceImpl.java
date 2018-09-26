package com.dl.service.impl;

import com.dl.entity.CategoryEntity;
import com.dl.entity.StockEntity;
import com.dl.mapper.StockMapper;
import com.dl.model.BaseModel;
import com.dl.model.StockModel;
import com.dl.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/26 10:09
 * @description 商品库存和进销货信息实现
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<StockEntity> searchStockList(StockModel model) {
        return stockMapper.selectGoodsStock(model);
    }

    @Override
    public Integer searchStockCount(StockModel model) {
        return stockMapper.selectStockCount(model);
    }

    @Override
    public List<CategoryEntity> searchCategoryList(BaseModel model) {
        return stockMapper.selectCategoryList(model);
    }

    @Override
    public Integer searchCategoryCount(BaseModel model) {
        return stockMapper.selectCategoryCount(model);
    }

}
