package com.dl.entity;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/25 10:27
 * @description 菜单信息
 */

@Data
public class MenuEntity extends BaseEntity {

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 状态：0-有效、1-无效
     */
    private Integer status;

    /**
     * 菜单排序
     */
    private Integer sort;
}
