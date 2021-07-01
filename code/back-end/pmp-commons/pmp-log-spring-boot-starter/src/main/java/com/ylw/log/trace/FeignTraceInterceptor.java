package com.ylw.log.trace;

import com.ylw.log.properties.TraceProperties;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


/**
 * feign拦截器，传递traceId
 *
 * @author : YangLinWei
 * @createTime: 2021/6/10 5:44 下午
 */
@ConditionalOnClass(value = {RequestInterceptor.class})
public class FeignTraceInterceptor {
    @Resource
    private TraceProperties traceProperties;

    @Bean
    public RequestInterceptor feignTraceInterceptor() {
        return template -> {
            if (traceProperties.getEnable()) {
                //传递日志traceId
                String traceId = MDCTraceUtils.getTraceId();
                if (!StringUtils.isEmpty(traceId)) {
                    template.header(MDCTraceUtils.TRACE_ID_HEADER, traceId);
                }
            }
        };
    }
}
