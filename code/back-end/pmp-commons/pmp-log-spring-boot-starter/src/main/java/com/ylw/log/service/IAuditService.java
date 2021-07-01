package com.ylw.log.service;


import com.ylw.log.model.Audit;

/**
 * 审计日志接口
 *
 * @author : YangLinWei
 * @createTime: 2021/6/10 5:42 下午
 */
public interface IAuditService {
    void save(Audit audit);
}
