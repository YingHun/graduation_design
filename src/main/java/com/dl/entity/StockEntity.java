package com.dl.entity;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/25 10:40
 * @description 商品库存信息
 */

@Data
public class StockEntity extends BaseEntity {

    /**
     * 商品类别
     */
    private String category;

    /**
     * 商品代码
     */
    private String code;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品剩余库存
     */
    private Integer stock;

    /**
     * 已销数量
     */
    private Integer sold;

    /**
     * 商品单价
     */
    private Double unitPrice;
}
