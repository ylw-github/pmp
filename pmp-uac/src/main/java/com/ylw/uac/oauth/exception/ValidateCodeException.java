package com.ylw.uac.oauth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常
 *
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:51 上午
 */
public class ValidateCodeException extends AuthenticationException {
	private static final long serialVersionUID = -7285211528095468156L;

	public ValidateCodeException(String msg) {
		super(msg);
	}
}
