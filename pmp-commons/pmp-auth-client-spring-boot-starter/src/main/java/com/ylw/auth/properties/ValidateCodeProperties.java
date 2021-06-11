package com.ylw.auth.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 验证码配置
 *
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:29 上午
 */
@Setter
@Getter
public class ValidateCodeProperties {
    /**
     * 设置认证通时不需要验证码的clientId
     */
    private String[] ignoreClientCode = {};
}
