package com.dl.mapper;

import com.dl.entity.CategoryEntity;
import com.dl.entity.StockEntity;
import com.dl.model.BaseModel;
import com.dl.model.StockModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/25 15:27
 * @description 库存信息增删查改
 */

@Mapper
public interface StockMapper {

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
}
