package com.master.springcloud.server.workbench;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.master.springcloud.server.workbench.mapper")
public class WorkbenchServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkbenchServerApplication.class, args);
    }
}
