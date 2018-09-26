package com.dl.util;

/**
 * @author Li Lun
 * @date 2018/9/26 11:22
 * @description 分页工具类
 */

public final class PageUtil {

    private static final Integer DEFAULT_PAGE = 1;

    public static Integer getStart(int page, int size) {
        return (page - DEFAULT_PAGE) * size;
    }
}
