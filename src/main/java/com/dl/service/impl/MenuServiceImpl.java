package com.dl.service.impl;

import com.dl.entity.MenuEntity;
import com.dl.mapper.MenuMapper;
import com.dl.service.MenuService;
import com.dl.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/18 13:32
 * @description 菜单信息
 */

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuEntity> searchMenuList() {
        return menuMapper.selectMenuList();
    }
}
