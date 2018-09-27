package com.dl.web;

import com.dl.entity.CategoryEntity;
import com.dl.entity.StockEntity;
import com.dl.model.StockModel;
import com.dl.service.GoodsService;
import com.dl.util.PageUtil;
import com.dl.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Li Lun
 * @date 2018/9/19 14:36
 * @description 商品库存信息
 */

@Controller
@RequestMapping("stock")
public class StockController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("view")
    public String view() {
        return "stock/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(Integer page, Integer limit) {
        StockModel stockModel = new StockModel();
        stockModel.setStart(PageUtil.getStart(page, limit));
        stockModel.setLimit(limit);

        List<StockEntity> resultList = goodsService.searchStockList(stockModel);
        if (CollectionUtils.isEmpty(resultList)) {
            resultList = Collections.EMPTY_LIST;
        }

        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("count", goodsService.searchStockCount(stockModel));
        resultMap.put("data", resultList);

        return ResponseResult.success(resultMap);
    }

    @RequestMapping("add")
    public String add() {
        return "stock/add";
    }

    @RequestMapping("edit/{code}")
    public String edit(@PathVariable String code, ModelMap modelMap) {
        StockModel model = new StockModel();
        model.setCode(code);

        StockEntity stockEntity = goodsService.searchGoodsByCode(model);
        List<CategoryEntity> categoryEntities = goodsService.searchCategories();
        modelMap.put("entity", stockEntity);
        modelMap.put("categories", categoryEntities);

        return "stock/edit";
    }
}
