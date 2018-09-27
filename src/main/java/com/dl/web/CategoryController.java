package com.dl.web;

import com.dl.entity.CategoryEntity;
import com.dl.model.BaseModel;
import com.dl.service.GoodsService;
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
 * @description 商品类别信息
 */

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("view")
    public String view() {
        return "category/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(Integer page, Integer limit) {
        BaseModel model = new BaseModel();
        model.setStart(PageUtil.getStart(page, limit));
        model.setLimit(limit);

        List<CategoryEntity> resultList = goodsService.searchCategoryList(model);
        if (CollectionUtils.isEmpty(resultList)) {
            resultList = Collections.EMPTY_LIST;
        }

        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("count", goodsService.searchCategoryCount(model));
        resultMap.put("data", resultList);

        return ResponseResult.success(resultMap);
    }
}
