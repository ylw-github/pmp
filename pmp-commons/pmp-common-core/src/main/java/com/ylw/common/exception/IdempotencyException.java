package com.ylw.common.exception;

/**
 * 幂等性异常
 *
 * @author : YangLinWei
 * @createTime: 2021/6/10 5:16 下午
 */
public class IdempotencyException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public IdempotencyException(String message) {
        super(message);
    }
}
