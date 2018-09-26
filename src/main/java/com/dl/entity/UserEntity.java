package com.dl.entity;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/18 13:33
 * @description 用户基本资料
 */

@Data
public class UserEntity extends BaseEntity {

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String header;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String postcode;

    /**
     * 密码
     */
    private String password;
}
