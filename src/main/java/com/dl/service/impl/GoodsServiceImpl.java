package com.dl.service.impl;

import com.dl.entity.CategoryEntity;
import com.dl.entity.InvoicingEntity;
import com.dl.entity.StockEntity;
import com.dl.mapper.GoodsMapper;
import com.dl.model.BaseModel;
import com.dl.model.InvoicingModel;
import com.dl.model.StockModel;
import com.dl.service.GoodsService;
import com.dl.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Li Lun
 * @date 2018/9/26 10:09
 * @description 商品库存和进销货信息实现
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    private static final Double TEN_THOUSAND = 10000.00;

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

    @Override
    public List<CategoryEntity> searchCategories() {
        return goodsMapper.selectCategories();
    }

    @Override
    public List<StockEntity> searchGoodsByCategory(StockModel model) {
        return goodsMapper.selectGoodsByCategory(model);
    }

    @Override
    public StockEntity searchGoodsByCode(StockModel model) {
        return goodsMapper.selectGoodsByCode(model);
    }

    @Override
    public String searchMaxGoodsCode(StockModel model) {
        return goodsMapper.selectMaxGoodsCode(model);
    }

    @Override
    public void appendGoods(StockEntity entity) {
        goodsMapper.insertGoods(entity);
    }

    @Override
    public void modifyGoods(StockEntity entity) {
        goodsMapper.updateGoods(entity);
    }

    @Override
    public Map<String, Object> searchSaleReport() {
        Map<String, Object> resultMap = new HashMap<>(3);

        List legend = new ArrayList<>();
        List quantity = new ArrayList<>();
        List money = new ArrayList<>();

        List<Map<String, Object>> resultList = goodsMapper.selectSaleReport();

        resultList.stream().forEach(map -> {
            legend.add(map.get("create_date").toString());
            quantity.add(MathUtil.divide(map.get("quantity"), TEN_THOUSAND));
            money.add(MathUtil.divide(map.get("money"), TEN_THOUSAND));
        });

        resultMap.put("legend", legend);
        resultMap.put("quantity", quantity);
        resultMap.put("money", money);

        return resultMap;
    }
}
