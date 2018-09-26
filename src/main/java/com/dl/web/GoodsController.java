package com.dl.web;

import com.dl.entity.CategoryEntity;
import com.dl.entity.InvoicingEntity;
import com.dl.entity.StockEntity;
import com.dl.model.BaseModel;
import com.dl.model.InvoicingModel;
import com.dl.model.StockModel;
import com.dl.service.GoodsService;
import com.dl.util.PageUtil;
import com.dl.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Li Lun
 * @date 2018/9/19 14:36
 * @description 商品信息
 */

@Slf4j
@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("category")
    public String category() {
        return "goods/category_list";
    }

    @RequestMapping("category/list")
    @ResponseBody
    public String categoryList(Integer page, Integer limit) {
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

    @GetMapping("stock")
    public String stock() {
        return "goods/stock_list";
    }

    @RequestMapping("stock/list")
    @ResponseBody
    public String stockList(Integer page, Integer limit) {
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

    @RequestMapping("invoicing")
    public String invoicing() {
        return "goods/invoicing_list";
    }

    @RequestMapping("invoicing/list")
    @ResponseBody
    public String invoicingList(Integer page, Integer limit) {
        InvoicingModel model = new InvoicingModel();
        model.setStart(PageUtil.getStart(page, limit));
        model.setLimit(limit);

        List<InvoicingEntity> resultList = goodsService.searchInvoicingList(model);
        if (CollectionUtils.isEmpty(resultList)) {
            resultList = Collections.EMPTY_LIST;
        }

        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("count", goodsService.searchInvoicingCount(model));
        resultMap.put("data", resultList);

        return ResponseResult.success(resultMap);
    }

    @GetMapping("report")
    public String report() {
        return "goods/goods_report";
    }
}
