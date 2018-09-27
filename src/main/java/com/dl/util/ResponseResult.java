package com.dl.util;

import com.dl.common.ResponseEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * @author Li Lun
 * @date 2018/9/26 10:25
 * @description 响应结果
 */

public final class ResponseResult {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String success() {
        return ResponseEnum.SUCCESS.toString();
    }

    public static String success(Object object) {
        try {
            Map<String, Object> resultMap = objectMapper.readValue(success(), Map.class);
            resultMap.put("data", object);

            return objectMapper.writeValueAsString(resultMap);
        } catch (IOException e) {
            throw new RuntimeException("parse json failed!");
        }
    }

    public static String success(Map<String, Object> params) {
        try {
            Map<String, Object> resultMap = objectMapper.readValue(success(), Map.class);
            resultMap.putAll(params);

            return objectMapper.writeValueAsString(resultMap);
        } catch (IOException e) {
            throw new RuntimeException("parse json failed!");
        }
    }
}
