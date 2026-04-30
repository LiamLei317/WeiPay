package com.weipay.channel.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 配置类
 * 
 * @author WeiPay
 * @since 1.0.0
 */
@Configuration
@MapperScan("com.weipay.channel.mapper")
public class MybatisConfig {
}
