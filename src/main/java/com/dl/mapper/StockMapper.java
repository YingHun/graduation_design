package com.dl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Li Lun
 * @date 2018/9/25 15:27
 * @description 库存信息增删查改
 */

@Mapper
public interface StockMapper {

    @Select("select * from tb_menu_info")
    List<Map<String, Object>> searchMenu();
}
