package com.kimzing.base.utils.result;

import lombok.Data;

/**
 * 成功返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/4 17:19
 */
@Data
public final class SuccessApiResult<T> extends ApiResult {

    public SuccessApiResult() {
        this(null);
    }

    public SuccessApiResult(T data) {
        this.ts = System.currentTimeMillis();
        this.code = "0";
        this.msg = "SUCCESS";
        this.data = data;
    }

    private T data;

}
