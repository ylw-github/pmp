package com.ylw.uac.oauth.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ylw.db.mapper.SuperMapper;
import com.ylw.uac.oauth.model.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author : YangLinWei
 * @createTime: 2021/6/11 9:54 上午
 */
@Mapper
public interface ClientMapper extends SuperMapper<Client> {
    List<Client> findList(Page<Client> page, @Param("params") Map<String, Object> params);
}
