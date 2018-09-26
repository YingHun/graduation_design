package com.dl.mapper;

import com.dl.entity.UserEntity;
import com.dl.model.BaseModel;
import com.dl.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
     * @param model 筛选条件
     * @return 返回用户信息
     */
    UserEntity selectUserInfo(UserModel model);

    /**
     * 查询用户列表
     *
     * @param model 筛选条件
     * @return 返回用户列表信息
     */
    List<UserEntity> selectUserList(UserModel model);

    /**
     * 查询用户列表
     *
     * @param model 筛选条件
     * @return 返回用户列表信息
     */
    Integer selectUserCount(UserModel model);
}
