package com.master.springcloud.server.workbench;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WorkbenchServerApplicationTests {

    @Test
    void contextLoads() {
        UUID.randomUUID().toString(true);
    }

}
