package com.example.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class RedisConfiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.redis.pool")
//    public JedisPoolConfig getRedisConfig(){
//        JedisPoolConfig config = new JedisPoolConfig();
//        return config;
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.redis")
//    public JedisConnectionFactory getConnectionFactory() {
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        factory.setUsePool(true);
//        JedisPoolConfig config = getRedisConfig();
//        factory.setPoolConfig(config);
//        return factory;
//    }

//    @Bean
//    public RedisTemplate<?, ?> getRedisTemplate() {
//        JedisConnectionFactory factory = getConnectionFactory();
//        RedisTemplate<?, ?> template = new StringRedisTemplate(factory);
//        return template;
//    }

}