package com.dl.service;

import com.dl.entity.MenuEntity;

import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/18 13:32
 * @description 菜单信息
 */

public interface MenuService {

    /**
     * 获取菜单列表
     *
     * @return  返回菜单列表信息
     */
    List<MenuEntity> searchMenuList();
}
