package com.dl.model;

import lombok.Data;

/**
 * @author Li Lun
 * @date 2018/9/26 14:13
 * @description 用户信息查询条件
 */

@Data
public class UserModel extends BaseModel {

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
