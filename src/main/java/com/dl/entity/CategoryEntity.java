package com.dl.entity;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/25 10:29
 * @description 商品类别信息
 */

@Data
public class CategoryEntity extends BaseEntity {

    /**
     * 商品类别编号
     */
    private String code;

    /**
     * 商品类别名称
     */
    private String name;

    /**
     * 状态：active-有效、inactive-无效
     */
    private String status;
}
