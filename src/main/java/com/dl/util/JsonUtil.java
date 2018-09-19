package com.dl.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Li Lun
 * @date 2018/9/17 13:08
 * @description JSON工具类
 */

public final class JsonUtil {

    public static String getFromJson(String jsonPath) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mock/order.json");
        ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream();

        try {
            byte[] buffer = new byte[1024];
            int index = 0;
            while ((index = inputStream.read(buffer)) > 0) {
                arrayOutput.write(buffer, 0, index);
            }
        } catch (IOException e) {
            throw new RuntimeException("parse error! caused by {}", e);
        }

        return new String(arrayOutput.toByteArray());
    }
}
