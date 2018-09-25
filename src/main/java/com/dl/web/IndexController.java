package com.dl.web;

import com.dl.config.SessionStorageConfig;
import com.dl.entity.UserEntity;
import com.dl.service.MenuService;
import com.dl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Li Lun
 * @date 2018/9/17 13:08
 * @description 程序登录和启动
 */

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @GetMapping({"/", "login"})
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index(UserEntity userEntity, ModelMap modelMap) {
        UserEntity entity = userService.searchUser(userEntity);
        if (Objects.isNull(entity)) {
            return "login";
        }

        modelMap.put("menus", menuService.searchMenuList());
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
