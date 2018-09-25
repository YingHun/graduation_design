package com.dl.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Li Lun
 * @date 2018/9/25 10:25
 * @description 基础信息类
 */

@Data
public class BaseEntity {

    /**
     * 序号
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
