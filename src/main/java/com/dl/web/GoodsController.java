package com.dl.web;

import com.dl.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Li Lun
 * @date 2018/9/19 14:36
 * @description 商品信息
 */

@Controller
@RequestMapping("goods")
public class GoodsController {

    @RequestMapping("item")
    public String item() {
        return "order/order_item";
    }

    @RequestMapping("list")
    @ResponseBody
    public String list() throws IOException {
        return JsonUtil.getFromJson("mock/order.json");
    }

    @GetMapping("stock")
    public String stock() {
        return "goods/stock_list";
    }

    @GetMapping("purchase")
    public String purchase() {
        return "goods/purchase_list";
    }

    @GetMapping("sold")
    public String sold() {
        return "goods/sold_list";
    }

    @GetMapping("report")
    public String report() {
        return "goods/goods_report";
    }
}
