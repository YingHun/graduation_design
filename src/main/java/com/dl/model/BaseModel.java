package com.dl.model;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/26 13:51
 * @description 基础查询参数
 */

@Data
public class BaseModel {

    /**
     * 起始行
     */
    private Integer start;

    /**
     * 当前页
     */
    private Integer page;

    /**
     * 每页记录数
     */
    private Integer limit;
}
