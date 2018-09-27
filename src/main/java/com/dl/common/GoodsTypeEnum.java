package com.dl.common;

/**
 * @author Li Lun
 * @date 2018/9/17 13:11
 * @description 商品进销货类型
 */

public enum GoodsTypeEnum {

    IN("in"), OUT("out");

    private String type;

    GoodsTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
