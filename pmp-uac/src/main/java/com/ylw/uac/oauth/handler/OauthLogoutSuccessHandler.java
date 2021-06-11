package com.ylw.uac.oauth.handler;

import cn.hutool.core.util.StrUtil;
import com.ylw.common.model.Result;
import com.ylw.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:54 上午
 */
@Slf4j
public class OauthLogoutSuccessHandler implements LogoutSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String redirectUri = request.getParameter("redirect_uri");
		if (StrUtil.isNotEmpty(redirectUri)) {
			//重定向指定的地址
			redirectStrategy.sendRedirect(request, response, redirectUri);
		} else {
			response.setStatus(HttpStatus.OK.value());
			response.setCharacterEncoding("UTF-8");
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			PrintWriter writer = response.getWriter();
			String jsonStr = JsonUtil.toJSONString(Result.succeed("登出成功"));
			writer.write(jsonStr);
			writer.flush();
		}
	}
}
