package com.dl.web;

import com.dl.entity.UserEntity;
import com.dl.model.UserModel;
import com.dl.service.UserService;
import com.dl.util.PageUtil;
import com.dl.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Li Lun
 * @date 2018/9/19 14:36
 * @description 用户
 */

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("info")
    public String category() {
        return "user/user_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public String categoryList(Integer page, Integer limit) {
        UserModel model = new UserModel();
        model.setStart(PageUtil.getStart(page, limit));
        model.setLimit(limit);

        List<UserEntity> resultList = userService.searchUserList(model);
        if (CollectionUtils.isEmpty(resultList)) {
            resultList = Collections.EMPTY_LIST;
        }

        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("count", userService.searchUserCount(model));
        resultMap.put("data", resultList);

        return ResponseResult.success(resultMap);
    }
}
