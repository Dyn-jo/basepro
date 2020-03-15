package com.dyn.basepro.frame.redis;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.dyn.basepro.frame.exception.BusinessException;
import com.dyn.basepro.frame.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Slf4j
public abstract class BaseRedisService {

    protected abstract JedisPool getJedisPool() throws Exception;

    public void flushDb() {
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
            jedis.flushDB();
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        } finally {
            closeResource(jedis);
        }
    }

    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        } finally {
            closeResource(jedis);
        }
    }

    public void setEntity(String key, Object o) {
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
            jedis.set(key, JSONUtil.parse(o).toString());
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        } finally {
            closeResource(jedis);
        }
    }

    public String get(String key) {
        String value;
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        } finally {
            closeResource(jedis);
        }
        return value;
    }

    public Object getEntity(String key, Object o) {
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
            String value = jedis.get(key);
            JSONObject jsonObject = JSONUtil.parseObj(value);
            o = JSONUtil.toBean(jsonObject, o.getClass());
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        } finally {
            closeResource(jedis);
        }
        return o;
    }

    public void closeResource(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        }
    }

}
