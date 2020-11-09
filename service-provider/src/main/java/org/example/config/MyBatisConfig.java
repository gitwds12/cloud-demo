package org.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created  on 2020/8/25.
 */
@Configuration
@MapperScan("org.example.mapper")
public class MyBatisConfig {
}
