package com.dl.mapper;

import com.dl.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li Lun
 * @date 2018/9/18 13:31
 * @description 用户信息增删查改
 */

@Mapper
public interface UserMapper {

    /**
     * 查询用户信息
     *
     * @param entity 查询条件
     * @return 返回用户信息
     */
    UserEntity selectUserInfo(UserEntity entity);
}
