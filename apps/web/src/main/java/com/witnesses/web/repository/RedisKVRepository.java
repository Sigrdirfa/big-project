package com.witnesses.web.repository;

import com.witnesses.web.entity.RedisKV;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisKVRepository {
    private static final String REDIS_KV = "redisKV";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void save(RedisKV redisKV) {
        redisTemplate.opsForHash().put(REDIS_KV, redisKV.getId(), redisKV.getValue());
    }

    public Object getRedisKvById(String id) {
        return redisTemplate.opsForHash().get(REDIS_KV, id);
    }
}
