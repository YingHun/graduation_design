package com.dl.web;

import com.dl.config.SessionStorageConfig;
import com.dl.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Li Lun
 * @date 2018/9/17 13:08
 * @description 程序登录和启动
 */

@Slf4j
@Controller
public class IndexController {

    @GetMapping({"/", "login"})
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index(UserEntity userEntity) {
        log.info("userEntity: {}", userEntity);
        return "index";
    }

    @PostMapping("logout")
    public String logout(HttpServletRequest httpServletRequest, Integer userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        SessionStorageConfig.clearSession(userEntity);
        return "login";
    }
}
