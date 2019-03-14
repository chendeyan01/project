package com.xcclass.zl_lock.redislock;

public interface Extlock {
    String getLock(String lockKey, Long acquireTimeout, Long timeOut);

    void unLock(String identity, String lockName);
}
