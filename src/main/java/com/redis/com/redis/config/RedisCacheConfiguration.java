package com.redis.com.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisCacheConfiguration {

    @Value("redis-19679.c9.us-east-1-2.ec2.cloud.redislabs.com:19679\n")
    private String redisHost;

    @Value("19679")
    private int redisPort;

    @Value("vEtESnyrLb8aWEtj31VkmYHKFmyWZPER")
    private String redisPassword;

    @Value("Samuele-free-db")
    private String redisDatabase;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandAloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
        redisStandAloneConfiguration.setPassword(RedisPassword.of(redisPassword));
        redisStandAloneConfiguration.setDatabase(0);
        return new JedisConnectionFactory(redisStandAloneConfiguration);
    }

    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;

}
}

