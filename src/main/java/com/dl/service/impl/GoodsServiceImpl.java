package com.dl.service.impl;

import com.dl.common.GoodsTypeEnum;
import com.dl.common.StockTypeEnum;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Li Lun
 * @date 2018/9/26 10:09
 * @description 商品库存和进销货信息实现
 */

@Service
@Transactional(rollbackFor = Exception.class)
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
    public void appendGoods(StockEntity entity) {
        String maxCode = goodsMapper.selectMaxGoodsCode(entity);
        AtomicLong currentCode = new AtomicLong(Long.parseLong(maxCode));

        // 自动获取商品分类下最大商品编码，然后在此编码上进行自增生成新的商品编码
        entity.setCode(String.valueOf(currentCode.incrementAndGet()));

        goodsMapper.insertGoods(entity);
    }

    @Override
    public void appendInvoicing(InvoicingEntity entity) {
        try {
            goodsMapper.insertInvoicing(entity);

            StockModel model = new StockModel();
            model.setCode(entity.getCode());
            StockEntity stockEntity = goodsMapper.selectGoodsByCode(model);

            // 如果是进货，除了记录进货明细表以外还需要更新库存表剩余库存
            if (GoodsTypeEnum.IN.getType().equals(entity.getType())) {
                stockEntity.setStock(stockEntity.getStock() + entity.getQuantity());
                // 如果库存剩余量为0，则商品状态为已上架状态
                if (stockEntity.getStock() > 0) {
                    stockEntity.setStatus(StockTypeEnum.SHELF.getStatus());
                }
            }

            // 如果是出货，除了记录出货明细表以外还需要更新库存表剩余库存和已售数量
            if (GoodsTypeEnum.OUT.getType().equals(entity.getType())) {
                int stock = stockEntity.getStock() - entity.getQuantity();
                stockEntity.setStock(stock);
                stockEntity.setSoldQuantity(stockEntity.getSoldQuantity() + entity.getQuantity());
                // 如果库存剩余量为0，则商品状态为缺货状态
                if (stock == 0) {
                    stockEntity.setStatus(StockTypeEnum.LACK.getStatus());
                }
            }

            goodsMapper.updateGoods(stockEntity);
        } catch (Exception e) {
            throw new RuntimeException("record goods information error!" + e);
        }
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
            quantity.add(map.get("quantity"));
            money.add(MathUtil.divide(map.get("money"), TEN_THOUSAND));
        });

        resultMap.put("legend", legend);
        resultMap.put("quantity", quantity);
        resultMap.put("money", money);

        return resultMap;
    }
}
