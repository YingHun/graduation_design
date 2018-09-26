package com.dl.entity;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/25 10:32
 * @description 商品进销信息
 */

@Data
public class InvoicingEntity extends BaseEntity {

    /**
     * 商品类别
     */
    private String category;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 进出货联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 供货地址
     */
    private String address;

    /**
     * 进出货数量
     */
    private Integer quantity;

    /**
     * 进出货单价
     */
    private Double unitPrice;

    /**
     * 折扣
     */
    private Double discount;

    /**
     * 优惠金额
     */
    private Double discountedPrice;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 状态：0-进货、1-出货
     */
    private String type;
}
