package com.dl.service.impl;

import com.dl.entity.CategoryEntity;
import com.dl.entity.InvoicingEntity;
import com.dl.entity.StockEntity;
import com.dl.mapper.GoodsMapper;
import com.dl.model.BaseModel;
import com.dl.model.InvoicingModel;
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
    private GoodsMapper goodsMapper;

    @Override
    public List<StockEntity> searchStockList(StockModel model) {
        return goodsMapper.selectGoodsStock(model);
    }

    @Override
    public Integer searchStockCount(StockModel model) {
        return goodsMapper.selectStockCount(model);
    }

    @Override
    public List<CategoryEntity> searchCategoryList(BaseModel model) {
        return goodsMapper.selectCategoryList(model);
    }

    @Override
    public Integer searchCategoryCount(BaseModel model) {
        return goodsMapper.selectCategoryCount(model);
    }

    @Override
    public List<InvoicingEntity> searchInvoicingList(InvoicingModel model) {
        return goodsMapper.selectInvoicingList(model);
    }

    @Override
    public Integer searchInvoicingCount(InvoicingModel model) {
        return goodsMapper.selectInvoicingCount(model);
    }

}
