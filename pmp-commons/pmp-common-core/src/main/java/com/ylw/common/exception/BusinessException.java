package com.ylw.common.exception;

/**
 * 业务异常
 *
 * @author : YangLinWei
 * @createTime: 2021/6/10 5:16 下午
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public BusinessException(String message) {
        super(message);
    }
}
