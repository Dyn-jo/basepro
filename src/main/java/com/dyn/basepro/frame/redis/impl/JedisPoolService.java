package  com.dyn.basepro.frame.redis.impl;

import   com.dyn.basepro.frame.exception.BusinessException;
import   com.dyn.basepro.frame.exception.ErrorCodes;
import  com.dyn.basepro.frame.redis.RedisConst;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JedisPoolService {

    private Map<Integer, JedisPool> jedisPools = new ConcurrentHashMap();

    @Resource
    private JedisPool jedisPoolDB0;

    @Resource
    private JedisPool jedisPoolDB1;

    @Resource
    private JedisPool jedisPoolDB2;

    @Resource
    private JedisPool jedisPoolDB3;

    @Resource
    private JedisPool jedisPoolDB4;

    @Resource
    private JedisPool jedisPoolDB5;

    @Resource
    private JedisPool jedisPoolDB6;

    @Resource
    private JedisPool jedisPoolDB7;

    @Resource
    private JedisPool jedisPoolDB8;

    @Resource
    private JedisPool jedisPoolDB9;

    @Resource
    private JedisPool jedisPoolDB10;

    @Resource
    private JedisPool jedisPoolDB11;

    @Resource
    private JedisPool jedisPoolDB12;

    @Resource
    private JedisPool jedisPoolDB13;

    @Resource
    private JedisPool jedisPoolDB14;

    @Resource
    private JedisPool jedisPoolDB15;

    @PostConstruct
    public void initPools() {
        jedisPools.put(RedisConst.DB_0, jedisPoolDB0);
        jedisPools.put(RedisConst.DB_1, jedisPoolDB1);
        jedisPools.put(RedisConst.DB_2, jedisPoolDB2);
        jedisPools.put(RedisConst.DB_3, jedisPoolDB3);
        jedisPools.put(RedisConst.DB_4, jedisPoolDB4);
        jedisPools.put(RedisConst.DB_5, jedisPoolDB5);
        jedisPools.put(RedisConst.DB_6, jedisPoolDB6);
        jedisPools.put(RedisConst.DB_7, jedisPoolDB7);
        jedisPools.put(RedisConst.DB_8, jedisPoolDB8);
        jedisPools.put(RedisConst.DB_9, jedisPoolDB9);
        jedisPools.put(RedisConst.DB_10, jedisPoolDB10);
        jedisPools.put(RedisConst.DB_11, jedisPoolDB11);
        jedisPools.put(RedisConst.DB_12, jedisPoolDB12);
        jedisPools.put(RedisConst.DB_13, jedisPoolDB13);
        jedisPools.put(RedisConst.DB_14, jedisPoolDB14);
        jedisPools.put(RedisConst.DB_15, jedisPoolDB15);
    }

    public JedisPool switchCacheDB(int database) throws BusinessException {
        if (!jedisPools.containsKey(database)) {
            throw new BusinessException(ErrorCodes.SYSTEM_ERROR);
        }
        return jedisPools.get(database);
    }

}
