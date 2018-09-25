package com.dl.mapper;

import com.dl.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/25 11:09
 * @description 菜单信息增删查改
 */

@Mapper
public interface MenuMapper {

    /**
     * 查询所有菜单信息
     *
     * @return 返回菜单信息
     */
    List<MenuEntity> selectMenuList();
}
