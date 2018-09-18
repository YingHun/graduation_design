package com.dl.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Li Lun
 * @date 2018/9/18 13:33
 * @description 用户基本资料
 */

@Slf4j
@Data
public class UserEntity {

    /**
     * 编号
     */
    private Long id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别
     */
    private Integer gender;

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
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
