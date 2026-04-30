package com.weipay.channel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * WeiPay 渠道模块启动类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@SpringBootApplication(scanBasePackages = "com.weipay")
@MapperScan("com.weipay.channel.mapper")
public class WeipayChannelApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeipayChannelApplication.class, args);
    }
}
