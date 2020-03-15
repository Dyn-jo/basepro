package com.dyn.basepro.frame.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@Data
public class Redis {

    @Value("${spring.redis.host:}")
    String host;

    @Value("${spring.redis.password:}")
    String password;

    @Value("${spring.redis.port:0}")
    int port;

    @Value("${spring.redis.timeout:}")
    int timeout;

    @Bean(name = "jedisPoolDB0")
    public JedisPool jedisPoolDB0() {
        return getJedisPool(RedisConst.DB_0);
    }

    @Bean(name = "jedisPoolDB1")
    public JedisPool jedisPoolDB1() {
        return getJedisPool(RedisConst.DB_1);
    }

    @Bean(name = "jedisPoolDB2")
    public JedisPool jedisPoolDB2() {
        return getJedisPool(RedisConst.DB_2);
    }

    @Bean(name = "jedisPoolDB3")
    public JedisPool jedisPoolDB3() {
        return getJedisPool(RedisConst.DB_3);
    }

    @Bean(name = "jedisPoolDB4")
    public JedisPool jedisPoolDB4() {
        return getJedisPool(RedisConst.DB_4);
    }

    @Bean(name = "jedisPoolDB5")
    public JedisPool jedisPoolDB5() {
        return getJedisPool(RedisConst.DB_5);
    }

    @Bean(name = "jedisPoolDB6")
    public JedisPool jedisPoolDB6() {
        return getJedisPool(RedisConst.DB_6);
    }

    @Bean(name = "jedisPoolDB7")
    public JedisPool jedisPoolDB7() {
        return getJedisPool(RedisConst.DB_7);
    }

    @Bean(name = "jedisPoolDB8")
    public JedisPool jedisPoolDB8() {
        return getJedisPool(RedisConst.DB_8);
    }

    @Bean(name = "jedisPoolDB9")
    public JedisPool jedisPoolDB9() {
        return getJedisPool(RedisConst.DB_9);
    }

    @Bean(name = "jedisPoolDB10")
    public JedisPool jedisPoolDB10() {
        return getJedisPool(RedisConst.DB_10);
    }

    @Bean(name = "jedisPoolDB11")
    public JedisPool jedisPoolDB11() {
        return getJedisPool(RedisConst.DB_11);
    }

    @Bean(name = "jedisPoolDB12")
    public JedisPool jedisPoolDB12() {
        return getJedisPool(RedisConst.DB_12);
    }

    @Bean(name = "jedisPoolDB13")
    public JedisPool jedisPoolDB13() {
        return getJedisPool(RedisConst.DB_13);
    }

    @Bean(name = "jedisPoolDB14")
    public JedisPool jedisPoolDB14() {
        return getJedisPool(RedisConst.DB_14);
    }

    @Bean(name = "jedisPoolDB15")
    public JedisPool jedisPoolDB15() {
        return getJedisPool(RedisConst.DB_15);
    }

    // 获取指定数据库的连接池
    private JedisPool getJedisPool(int database) {
        JedisPoolConfig conf = new JedisPoolConfig();
        conf.setTestOnBorrow(true);
        conf.setTestWhileIdle(true);
        conf.setTestOnReturn(true);
        return new JedisPool(conf, host, port, timeout, StringUtils.isEmpty(password) ? null : password, database);
    }

}
