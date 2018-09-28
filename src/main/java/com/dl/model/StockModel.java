package com.dl.model;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/26 11:11
 * @description 库存信息查询
 */

@Data
public class StockModel extends BaseModel {

    /**
     * 商品类别
     */
    private String category;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品状态
     */
    private String status;
}
