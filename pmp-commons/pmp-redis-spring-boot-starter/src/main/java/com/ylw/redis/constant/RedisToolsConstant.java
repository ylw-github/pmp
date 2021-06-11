package com.ylw.redis.constant;

/**
 * redis 工具常量
 *
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:10 上午
 */
public class RedisToolsConstant {
    private RedisToolsConstant() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * single Redis
     */
    public final static int SINGLE = 1;

    /**
     * Redis cluster
     */
    public final static int CLUSTER = 2;
}
