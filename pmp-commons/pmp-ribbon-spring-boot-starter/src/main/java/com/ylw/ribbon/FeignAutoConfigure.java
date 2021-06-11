package com.ylw.ribbon;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * Feign统一配置
 *
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:20 上午
 */
public class FeignAutoConfigure {

    /**
     * Feign 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
