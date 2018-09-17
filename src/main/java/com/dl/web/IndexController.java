package com.dl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Li Lun
 * @date 2018/9/17 13:08
 * @description 程序登录和启动
 */

@Controller
public class IndexController {

    @GetMapping({"/", "index"})
    public String index() {
        return "login";
    }

    @PostMapping("login")
    public String login() {
        return "index";
    }

    @PostMapping("logout")
    public String logout() {
        return "login";
    }
}
