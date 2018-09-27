package com.dl.common;

/**
 * @author Li Lun
 * @date 2018/9/17 13:11
 * @description 商品进销货类型
 */

public enum ProductTypeEnum {

    IN("in"), OUT("out");

    private String type;

    ProductTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
