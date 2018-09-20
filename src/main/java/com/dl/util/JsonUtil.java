package com.dl.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Li Lun
 * @date 2018/9/17 13:08
 * @description JSON工具类
 */

public final class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String getFromJson(String jsonPath) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(jsonPath);
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

    public static <T> T parseJson(String json, Class<T> clazz) {
        T t;
        try {
            t = objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("parse json to " + clazz.getSimpleName() + " failed!");
        }

        return t;
    }
}
