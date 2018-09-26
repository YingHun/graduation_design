package com.dl.model;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/26 11:11
 * @description 商品进销信息
 */

@Data
public class InvoicingModel extends BaseModel {

    /**
     * 商品类别
     */
    private String category;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 类型：in-进货、out-出货
     */
    private String type;
}
