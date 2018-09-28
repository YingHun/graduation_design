package com.dl.mapper;

import com.dl.entity.CategoryEntity;
import com.dl.entity.InvoicingEntity;
import com.dl.entity.StockEntity;
import com.dl.model.BaseModel;
import com.dl.model.InvoicingModel;
import com.dl.model.StockModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Li Lun
 * @date 2018/9/25 15:27
 * @description 库存信息增删查改
 */

@Mapper
public interface GoodsMapper {

    /**
     * 查询商品库存信息
     *
     * @param model 筛选条件
     * @return 返回商品库存信息
     */
    List<StockEntity> selectGoodsStock(StockModel model);

    /**
     * 查询数据总量
     *
     * @param model 筛选条件
     * @return 返回总记录数
     */
    Integer selectStockCount(StockModel model);

    /**
     * 查询分类信息
     *
     * @param model 筛选条件
     * @return 返回分类信息
     */
    List<CategoryEntity> selectCategoryList(BaseModel model);

    /**
     * 查询数据总量
     *
     * @param model 筛选条件
     * @return 返回总记录数
     */
    Integer selectCategoryCount(BaseModel model);

    /**
     * 查询进销货信息
     *
     * @param model 筛选条件
     * @return 返回分类信息
     */
    List<InvoicingEntity> selectInvoicingList(InvoicingModel model);

    /**
     * 查询数据总量
     *
     * @param model 筛选条件
     * @return 返回总记录数
     */
    Integer selectInvoicingCount(InvoicingModel model);

    /**
     * 查询所有分类信息
     *
     * @return 返回分类信息列表
     */
    List<CategoryEntity> selectCategories();

    /**
     * 根据分类标识查询商品信息
     *
     * @param model 筛选条件
     * @return 返回商品信息
     */
    List<StockEntity> selectGoodsByCategory(StockModel model);

    /**
     * 根据商品编码获取商品信息
     *
     * @param model 筛选条件
     * @return 返回商品信息
     */
    StockEntity selectGoodsByCode(StockModel model);

    /**
     * 根据商品分类下最大商品编码
     *
     * @param entity 筛选条件
     * @return 返回最大商品编码
     */
    String selectMaxGoodsCode(StockEntity entity);

    /**
     * 添加商品信息
     *
     * @param entity 商品信息
     */
    void insertGoods(StockEntity entity);

    /**
     * 添加进销货明细
     *
     * @param entity 进销货信息
     */
    void insertInvoicing(InvoicingEntity entity);

    /**
     * 更新商品信息
     *
     * @param entity 商品信息
     */
    void updateGoods(StockEntity entity);

    /**
     * 获取销售报表数据
     *
     * @return 返回销售报表数据
     */
    List<Map<String, Object>> selectSaleReport();
}
