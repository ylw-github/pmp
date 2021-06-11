package com.ylw.uac.oauth.service;


import com.ylw.common.model.PageResult;
import com.ylw.uac.oauth.model.TokenVo;

import java.util.Map;
/**
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:56 上午
 */
public interface ITokensService {
    /**
     * 查询token列表
     * @param params 请求参数
     * @param clientId 应用id
     */
    PageResult<TokenVo> listTokens(Map<String, Object> params, String clientId);
}
