package com.kimzing.base.utils.result;

import lombok.NoArgsConstructor;

/**
 * 成功返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/4 17:19
 */
@NoArgsConstructor
public final class ErrorApiResult extends ApiResult {

    public ErrorApiResult(String code) {
        this.ts = System.currentTimeMillis();
        this.code = code;
        this.msg = getMessageByCode(code);
    }

    public ErrorApiResult(String code, String msg) {
        this.ts = System.currentTimeMillis();
        this.code = code;
        this.msg = msg;
    }
}
