package com.witnesses.web;

import com.witnesses.web.entity.RedisKV;
import com.witnesses.web.repository.RedisKVRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
@Slf4j
public class RedisTest {
    @Resource
    private RedisKVRepository redisKVRepository;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        redisKVRepository.save(new RedisKV("1", "value1"));
        log.info("redis test result: {}", redisKVRepository.getRedisKvById("1"));
    }

}
