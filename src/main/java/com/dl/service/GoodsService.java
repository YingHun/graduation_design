package com.dl.service;

import com.dl.entity.CategoryEntity;
import com.dl.entity.InvoicingEntity;
import com.dl.entity.StockEntity;
import com.dl.model.BaseModel;
import com.dl.model.InvoicingModel;
import com.dl.model.StockModel;

import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/26 10:07
 * @description 商品库存和进销货信息
 */

public interface GoodsService {

    /**
     * 查询商品库存信息
     *
     * @param model 筛选条件
     * @return 返回商品库存信息
     */
    List<StockEntity> searchStockList(StockModel model);

    /**
     * 查询数据总量
     *
     * @param model 筛选条件
     * @return 返回总记录数
     */
    Integer searchStockCount(StockModel model);

    /**
     * 查询分类信息
     *
     * @param model 筛选条件
     * @return 返回分类信息
     */
    List<CategoryEntity> searchCategoryList(BaseModel model);

    /**
     * 查询数据总量
     *
     * @param model 筛选条件
     * @return 返回总记录数
     */
    Integer searchCategoryCount(BaseModel model);


    /**
     * 查询进销货信息
     *
     * @param model 筛选条件
     * @return 返回分类信息
     */
    List<InvoicingEntity> searchInvoicingList(InvoicingModel model);

    /**
     * 查询数据总量
     *
     * @param model 筛选条件
     * @return 返回总记录数
     */
    Integer searchInvoicingCount(InvoicingModel model);

    /**
     * 查询所有分类信息
     *
     * @return 返回分类信息列表
     */
    List<CategoryEntity> searchCategories();

    /**
     * 根据分类标识查询商品信息
     *
     * @param model 筛选条件
     * @return 返回商品信息
     */
    List<StockEntity> searchGoodsByCategory(StockModel model);

    /**
     * 根据商品编码获取商品信息
     *
     * @param model 筛选条件
     * @return 返回商品信息
     */
    StockEntity searchGoodsByCode(StockModel model);

    /**
     * 根据商品分类下最大商品编码
     *
     * @param model 筛选条件
     * @return 返回最大商品编码
     */
    String searchMaxGoodsCode(StockModel model);

    /**
     * 添加商品信息
     *
     * @param entity 商品信息
     */
    void appendGoods(StockEntity entity);

    /**
     * 更新商品信息
     *
     * @param entity 商品信息
     */
    void modifyGoods(StockEntity entity);
}
