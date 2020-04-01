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

    /***
     *@Description: 设置key的值为value
     *@Param: [key, value]
     *@return: void
     *@Author: dyn
     *@date: 2020/4/1 0001 下午 9:11
     */
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
        set(key, JSONUtil.parse(o).toString());
    }

    /***
     *@Description: 获取指定key的值
     *@Param: [key]
     *@return: java.lang.String
     *@Author: dyn
     *@date: 2020/4/1 0001 下午 9:11
     */
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

        try {
            String value = get(key);
            JSONObject jsonObject = JSONUtil.parseObj(value);
            o = JSONUtil.toBean(jsonObject, o.getClass());
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        }
        return o;
    }

    /***
     *@Description: 删除指定的key, 也可以传入一个包含key的数组
     *@Param: [keys]
     *@return: java.lang.Long
     *@Author: dyn
     *@date: 2020/4/1 0001 下午 9:15
     */
    public Long del(String... keys) {
        Long value;
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
            value = jedis.del(keys);
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        } finally {
            closeResource(jedis);
        }
        return value;
    }

    /***
     *@Description: 判断key是否存在
     *@Param: [key]
     *@return: java.lang.Boolean
     *@Author: dyn
     *@date: 2020/4/1 0001 下午 9:16
     */
    public Boolean exists(String key) {
        Boolean value;
        Jedis jedis = null;
        try {
            jedis = getJedisPool().getResource();
            value = jedis.exists(key);
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        } finally {
            closeResource(jedis);
        }
        return value;
    }

    /***
     *@Description: 关闭连接
     *@Param: [jedis]
     *@return: void
     *@Author: dyn
     *@date: 2020/4/1 0001 下午 9:19
     */
    private void closeResource(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {
            throw new BusinessException(ResultCode.SYSTEM_ERROR);
        }
    }

}
