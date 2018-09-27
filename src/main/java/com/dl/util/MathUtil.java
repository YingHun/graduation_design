package com.dl.util;

import java.math.BigDecimal;

/**
 * @author Li Lun
 * @date 2018/9/27 17:51
 * @description 数学工具
 */

public final class MathUtil {

    public static double divide(Object value1, Object value2) {
        BigDecimal bigDecimal1 = new BigDecimal(value1.toString());
        BigDecimal bigDecimal2 = new BigDecimal(value2.toString());

        return bigDecimal1.divide(bigDecimal2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
