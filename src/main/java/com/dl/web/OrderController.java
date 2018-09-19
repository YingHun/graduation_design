package com.dl.web;

import com.dl.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Li Lun
 * @date 2018/9/19 14:36
 * @description 订单信息
 */

@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("item")
    public String item() {
        return "order/order_item";
    }

    @RequestMapping("list")
    @ResponseBody
    public String list() throws IOException {
        return JsonUtil.getFromJson("mock/order.json");
    }
}
