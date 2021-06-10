package com.ylw.common.exception;

/**
 * 分布式锁异常
 *
 * @author : YangLinWei
 * @createTime: 2021/6/10 5:16 下午
 */
public class LockException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public LockException(String message) {
        super(message);
    }
}
