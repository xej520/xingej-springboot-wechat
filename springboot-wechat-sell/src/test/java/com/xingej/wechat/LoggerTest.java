package com.xingej.wechat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testLogger() {
        logger.debug("-------");
        logger.info("info-----");
        logger.error("--error----");
    }

    // 测试在日志里，输出变量
    @Test
    public void testlog() {
        String name = "spring boot";
        String type = "spring";
        // 普通写法，缺点，拼接很麻烦的
        logger.info("name:" + name + ", type:\t" + type);

        // 推荐使用 下面的方式，进行输出
        // {}表示占位符的
        logger.info("name:{}, \ttype:\t{}", name, type);

        logger.warn("name:{}, \ttype:\t{}", name, type);

    }

}
