package com.dyn.basepro.frame.redis.impl;

import com.dyn.basepro.frame.exception.BusinessException;
import com.dyn.basepro.frame.redis.BaseRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

@Slf4j
@Service
public class RedisService extends BaseRedisService {

    @Value("${spring.redis.database:-1}")
    private int database;

    @Autowired
    JedisPoolService jedisPoolService;

    @Override
    protected JedisPool getJedisPool() throws BusinessException {
        if (database == -1) {
            return null;
        }
        return jedisPoolService.switchCacheDB(database);
    }

}
