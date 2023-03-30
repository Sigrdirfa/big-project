package com.witnesses.web;

import com.witnesses.web.entity.RedisKV;
import com.witnesses.web.repository.RedisKVRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RedisTest {
    @Resource
    private RedisKVRepository redisKVRepository;

    @Test
    public void testRedis() {
        redisKVRepository.save(new RedisKV("2", "value2"));
        log.info("redis test result: {}", redisKVRepository.getRedisKvById("1"));
    }

}
