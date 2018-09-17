package com.dl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Li Lun
 * @date 2018/9/17 11:09
 * @description 程序启动函数
 */

@SpringBootApplication(scanBasePackages = "com.dl", exclude = DataSourceAutoConfiguration.class)
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }
}
