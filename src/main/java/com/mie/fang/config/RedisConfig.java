package com.mie.fang.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.mie.util.MyRedisKeyGnerator;
import com.mie.util.PropertyPlaceholderUtil;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching  
public class RedisConfig {
    @Bean  
    public JedisConnectionFactory redisConnectionFactory() {  
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();  
  
        // Defaults  
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(300);//一个pool最多有多少个状态为idle(空闲)的jedis实例
        poolConfig.setMaxWaitMillis(20000);//当borrow一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException
        poolConfig.setTestOnBorrow(true);//在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的
        
        redisConnectionFactory.setPoolConfig(poolConfig);
        redisConnectionFactory.setHostName(PropertyPlaceholderUtil.getProperty("REDIS_HOST").toString());
        redisConnectionFactory.setPort(6379);  
        redisConnectionFactory.setPassword(PropertyPlaceholderUtil.getProperty("REDIS_PWD").toString());
        redisConnectionFactory.setTimeout(2000);
        redisConnectionFactory.setDatabase(1);
        return redisConnectionFactory;  
    }  

    @Bean  
    public RedisTemplate<String, String> redisTemplate() {
    	JedisConnectionFactory cf=redisConnectionFactory();
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();  
        redisTemplate.setConnectionFactory(cf);  
        return redisTemplate;  
    }  

    @Bean  
    public CacheManager cacheManager(RedisTemplate redisTemplate) {  
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);  
        // Number of seconds before expiration. Defaults to unlimited (0)  
        cacheManager.setDefaultExpiration(3000); // Sets the default expire time (in seconds)  
        return cacheManager;  
    }  

    @Bean
    public KeyGenerator keyGenerator() {  
        return new MyRedisKeyGnerator();  
    }
}
