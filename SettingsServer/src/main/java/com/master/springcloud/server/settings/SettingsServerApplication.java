package com.master.springcloud.server.settings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SettingsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SettingsServerApplication.class, args);
    }

}
