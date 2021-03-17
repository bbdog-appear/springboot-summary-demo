package com.bbdog.study.springboot.summary.demo.web.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *      配置mybatis参数
 * </p>
 *
 * @author cheng.wang
 * @version Id：MybatisConfig.java Date：2021/3/17 9:38 Version：1.0
 */
@Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer customizer(){
        return configuration -> {
            // 开启驼峰式命名转换：Table{create_time} -> Entity{createTime}
            configuration.setMapUnderscoreToCamelCase(true);
        };
    }

}
