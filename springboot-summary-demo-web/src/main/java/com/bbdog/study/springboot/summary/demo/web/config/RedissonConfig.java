package com.bbdog.study.springboot.summary.demo.web.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redissonClient() {
        // 创建配置对象
        Config config = new Config();

        // 配置哨兵模式
        config.useSentinelServers()
                .addSentinelAddress("redis://192.168.1.100:26379", "redis://192.168.1.101:26379", "redis://192.168.1.102:26379")
                .setMasterName("mymaster")
                .setPassword("your_password")
                .setDatabase(0);

        // 创建 Redisson 客户端
        return Redisson.create(config);
    }

}
