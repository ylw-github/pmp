package com.ylw.common.model;


/**
 *
 * @author : YangLinWei
 * @createTime: 2021/6/10 5:18 下午
 */
public enum CodeEnum {
    SUCCESS(0),
    ERROR(1);

    private Integer code;

    CodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
