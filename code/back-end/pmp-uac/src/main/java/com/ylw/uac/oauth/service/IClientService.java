package com.ylw.uac.oauth.service;


import com.ylw.common.model.PageResult;
import com.ylw.common.model.Result;
import com.ylw.common.service.ISuperService;
import com.ylw.uac.oauth.model.Client;

import java.util.Map;


/**
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:56 上午
 */
public interface IClientService extends ISuperService<Client> {
    Result saveClient(Client clientDto) throws Exception;

    /**
     * 查询应用列表
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClient(Map<String, Object> params, boolean isPage);

    void delClient(long id);

    Client loadClientByClientId(String clientId);
}
