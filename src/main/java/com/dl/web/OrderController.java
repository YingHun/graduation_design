package com.dl.web;

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
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mock/order.json");
        ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];

        int index = 0;
        while ((index = inputStream.read(buffer)) > 0) {
            arrayOutput.write(buffer, 0, index);
        }
        String result = new String(arrayOutput.toByteArray());
        return result;
    }
}
