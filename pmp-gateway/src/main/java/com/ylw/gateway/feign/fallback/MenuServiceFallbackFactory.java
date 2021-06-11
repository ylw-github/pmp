package com.ylw.gateway.feign.fallback;

import cn.hutool.core.collection.CollectionUtil;
import com.ylw.gateway.feign.MenuService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * menuService降级工场
 *
 * @author : YangLinWei
 * @createTime: 2021/6/11 4:08 下午
 */
@Slf4j
@Component
public class MenuServiceFallbackFactory implements FallbackFactory<MenuService> {
    @Override
    public MenuService create(Throwable throwable) {
        return roleIds -> {
            log.error("调用findByRoleCodes异常：{}", roleIds, throwable);
            return CollectionUtil.newArrayList();
        };
    }
}
