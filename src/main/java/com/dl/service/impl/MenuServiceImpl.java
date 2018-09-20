package com.dl.service.impl;

import com.dl.service.MenuService;
import com.dl.util.JsonUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/18 13:32
 * @description 菜单信息
 */

@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public List searchMenu() {
        try {
            String json = JsonUtil.getFromJson("mock/menu.json");
            return JsonUtil.parseJson(json, List.class);
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
