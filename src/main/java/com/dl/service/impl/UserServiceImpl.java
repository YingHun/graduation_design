package com.dl.service.impl;

import com.dl.entity.UserEntity;
import com.dl.mapper.UserMapper;
import com.dl.model.UserModel;
import com.dl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Li Lun
 * @date 2018/9/18 13:33
 * @description 用户信息增删查改实现
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity searchUser(UserModel model) {
        return userMapper.selectUserInfo(model);
    }

    @Override
    public List<UserEntity> searchUserList(UserModel model) {
        return userMapper.selectUserList(model);
    }

    @Override
    public Integer searchUserCount(UserModel model) {
        return userMapper.selectUserCount(model);
    }
}
