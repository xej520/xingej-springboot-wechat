package com.xingej.wechat.utils;

import java.util.Random;

/**
 * 
 * 主键工具类
 * 
 * @author erjun 2017年12月16日 下午12:43:21
 */

public class KeyUtil {

    /**
     * 生产主键
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer result = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(result);

    }
}
