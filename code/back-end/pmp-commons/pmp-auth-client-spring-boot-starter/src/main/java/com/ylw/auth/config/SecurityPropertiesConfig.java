package com.ylw.auth.config;

import com.ylw.auth.properties.SecurityProperties;
import com.ylw.auth.properties.TokenStoreProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:27 上午
 */
@EnableConfigurationProperties({SecurityProperties.class, TokenStoreProperties.class})
public class SecurityPropertiesConfig {
}
