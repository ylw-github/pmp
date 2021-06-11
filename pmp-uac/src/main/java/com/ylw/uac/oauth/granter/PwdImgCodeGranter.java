package com.ylw.uac.oauth.granter;

import com.ylw.uac.oauth.service.IValidateCodeService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * password添加图像验证码授权模式
 *
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:53 上午
 */
public class PwdImgCodeGranter extends ResourceOwnerPasswordTokenGranter {
    private static final String GRANT_TYPE = "password_code";

    private final IValidateCodeService validateCodeService;

    public PwdImgCodeGranter(AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices
            , ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory, IValidateCodeService validateCodeService) {
        super(authenticationManager, tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
        this.validateCodeService = validateCodeService;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> parameters = new LinkedHashMap<>(tokenRequest.getRequestParameters());
        String deviceId = parameters.get("deviceId");
        String validCode = parameters.get("validCode");
        //校验图形验证码
        validateCodeService.validate(deviceId, validCode);

        return super.getOAuth2Authentication(client, tokenRequest);
    }
}
