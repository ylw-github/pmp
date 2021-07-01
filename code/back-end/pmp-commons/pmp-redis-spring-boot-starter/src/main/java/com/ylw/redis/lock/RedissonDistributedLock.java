package com.ylw.redis.lock;

import com.ylw.common.constant.CommonConstant;
import com.ylw.common.exception.LockException;
import com.ylw.common.lock.DistributedLock;
import com.ylw.common.lock.YLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.concurrent.TimeUnit;

/**
 * redisson分布式锁实现，基本锁功能的抽象实现
 * 本接口能满足绝大部分的需求，高级的锁功能，请自行扩展或直接使用原生api
 *
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:10 上午
 */
@ConditionalOnClass(RedissonClient.class)
@ConditionalOnProperty(prefix = "ylw.lock", name = "lockerType", havingValue = "REDIS", matchIfMissing = true)
public class RedissonDistributedLock implements DistributedLock {
    @Autowired
    private RedissonClient redisson;

    private YLock getLock(String key, boolean isFair) {
        RLock lock;
        if (isFair) {
            lock = redisson.getFairLock(CommonConstant.LOCK_KEY_PREFIX + ":" + key);
        } else {
            lock =  redisson.getLock(CommonConstant.LOCK_KEY_PREFIX + ":" + key);
        }
        return new YLock(lock, this);
    }

    @Override
    public YLock lock(String key, long leaseTime, TimeUnit unit, boolean isFair) {
        YLock yLock = getLock(key, isFair);
        RLock lock = (RLock)yLock.getLock();
        lock.lock(leaseTime, unit);
        return yLock;
    }

    @Override
    public YLock tryLock(String key, long waitTime, long leaseTime, TimeUnit unit, boolean isFair) throws InterruptedException {
        YLock yLock = getLock(key, isFair);
        RLock lock = (RLock)yLock.getLock();
        if (lock.tryLock(waitTime, leaseTime, unit)) {
            return yLock;
        }
        return null;
    }

    @Override
    public void unlock(Object lock) {
        if (lock != null) {
            if (lock instanceof RLock) {
                RLock rLock = (RLock)lock;
                if (rLock.isLocked()) {
                    rLock.unlock();
                }
            } else {
                throw new LockException("requires RLock type");
            }
        }
    }
}
