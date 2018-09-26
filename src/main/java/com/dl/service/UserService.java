package com.dl.service;

import com.dl.entity.UserEntity;
import com.dl.model.UserModel;

import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/18 13:32
 * @description 用户信息增删查改
 */

public interface UserService {

    /**
     * 获取用户基本信息
     *
     * @param model 查询条件
     * @return 返回用户基本信息
     */
    UserEntity searchUser(UserModel model);

    /**
     * 查询用户列表
     *
     * @param model 筛选条件
     * @return 返回用户列表信息
     */
    List<UserEntity> searchUserList(UserModel model);

    /**
     * 查询用户列表
     *
     * @param model 筛选条件
     * @return 返回用户列表信息
     */
    Integer searchUserCount(UserModel model);
}
