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
}
