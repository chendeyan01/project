package com.xcclass.zl_lock.redislock;

import com.xcclass.zl_lock.redislock.util.JedisUtil;
import com.xcclass.zl_lock.zklock1.OrderNumGenerator;
import redis.clients.jedis.JedisPool;

public class OrderService implements Runnable {
    public static final String lockKey = "lock_cdy";
    private RedisDistrubteLock extLock = null;
    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
    private static JedisPool jedisPool;


    public OrderService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
        extLock = new RedisDistrubteLock(jedisPool);
    }

    @Override
    public void run() {
        createOrderNum();
    }

    @SuppressWarnings("all")
    public void createOrderNum() {
        String identity = null;
        try {
            identity = extLock.getLock(lockKey, 600000l, 1000l);
            String number = orderNumGenerator.getNumber();
            System.out.println("线程：" + Thread.currentThread().getName() + ",生成订单id：" + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            extLock.unLock(identity, lockKey);
        }
    }

    public static void main(String[] args) {
        jedisPool = JedisUtil.getInstance().getPool();
        OrderService orderService = new OrderService(jedisPool);
        for (int i = 0; i < 500; i++) {
            new Thread(orderService).start();
        }
    }
}
