package com.dl.common;

/**
 * @author Li Lun
 * @date 2018/9/28 13:11
 * @description 商品库存状态：0-已上架、1-已下架、2-缺货
 */

public enum StockTypeEnum {

    SHELF("0"), OBTAINED("1"), LACK("2");

    private String status;

    StockTypeEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
