package com.dl.service;

import com.dl.entity.UserEntity;

/**
 * @author Li Lun
 * @date 2018/9/18 13:32
 * @description 用户信息增删查改
 */

public interface UserService {

    /**
     * 获取用户基本信息
     *
     * @param entity 查询条件
     * @return 返回用户基本信息
     */
    UserEntity searchUser(UserEntity entity);
}
