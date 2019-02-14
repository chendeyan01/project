package com.xcclass.zl_lock.redislock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

public class RedisDistrubteLock implements Extlock {
    private JedisPool jedisPool;

    public RedisDistrubteLock(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public String getLock(String lockKey, Long acquireTimeout, Long timeOut) {
        //获取缓存连接
        Jedis conn = jedisPool.getResource();
        String retIdentity = null;
        //线程的唯一标识
        String identity = UUID.randomUUID().toString();
        //线程名称
        String lockName = "redis_lock" + lockKey;
        //上锁成功的超时时间
        int expireLock = (int) (timeOut / 1000);
        long endTime = System.currentTimeMillis() + acquireTimeout;
        try {
            while (System.currentTimeMillis() < endTime) {
                long setnx = conn.setnx(lockName, identity);
                if (setnx == 1) {
                    conn.expire(lockName, expireLock);
                    System.out.println("#####获取锁成功#####");
                    retIdentity = identity;
                    return identity;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return retIdentity;
    }

    @Override
    public void unLock(String currentIdentity, String lockKey) {
        Jedis conn = jedisPool.getResource();
        String lockName = "redis_lock" + lockKey;
        try {
            String identity = conn.get(lockName);
            //判断当前线程是否是持有锁线程 防止释放其他线程锁
            if (identity != null && currentIdentity != null && identity.equals(currentIdentity)) {
                conn.del(lockName);
                System.out.println("#####释放锁成功#####");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }

    }

}
