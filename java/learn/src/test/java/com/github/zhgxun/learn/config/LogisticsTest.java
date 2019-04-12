package com.github.zhgxun.learn.config;

import com.github.zhgxun.learn.common.config.LogisticsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogisticsTest {

    @Autowired
    private LogisticsConfig config;

    @Test
    public void test() {
        System.out.println(config.getLogistics());
    }
}
