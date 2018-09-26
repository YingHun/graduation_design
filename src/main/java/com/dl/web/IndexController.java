package com.dl.web;

import com.dl.config.SessionStorageConfig;
import com.dl.entity.UserEntity;
import com.dl.model.UserModel;
import com.dl.service.MenuService;
import com.dl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request, UserEntity userEntity, ModelMap modelMap) {
        if (StringUtils.isEmpty(userEntity.getAccount())) {
            modelMap.put("message", "账号不能为空！");
            return "login";
        }

        if (StringUtils.isEmpty(userEntity.getPassword())) {
            modelMap.put("message", "密码不能为空！");
            return "login";
        }

        UserModel model = new UserModel();
        model.setAccount(userEntity.getAccount());
        model.setPassword(userEntity.getPassword());

        UserEntity entity = userService.searchUser(model);
        if (Objects.isNull(entity)) {
            return "login";
        }

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("sessionData", entity);

        modelMap.put("menus", menuService.searchMenuList());
        return "index";
    }

    @PostMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("sessionData");
        return "redirect:/login?logout";
    }
}
