package com.xingej.wechat;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootWeChat.class)
@Slf4j // 此注解的作用，就是程序员不用在声明下面的日志对象了，直接调用log就可以了
// private Logger logger = LoggerFactory.getLogger(getClass());
public class BaseTest {

}
