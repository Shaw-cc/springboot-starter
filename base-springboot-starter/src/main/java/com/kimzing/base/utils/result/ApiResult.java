package com.kimzing.base.utils.result;

import com.kimzing.base.utils.spring.SpringPropertyUtil;

/**
 * 通用返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/4 15:04
 */
public abstract class ApiResult {

    public Long ts;

    public String code;

    public String message;

    /**
     * 创建成功返回体，无数据
     *
     * @return
     */
    public static ApiResult success() {
        return new SuccessApiResult();
    }

    /**
     * 创建成功返回体，包含数据
     *
     * @param data 数据体
     * @return
     */
    public static <T> ApiResult success(T data) {
        return new SuccessApiResult(data);
    }

    /**
     * 创建错误返回体，通过code在配置文件进行读取相应错误信息
     *
     * @param codes 错误码
     * @return
     */
    public static ApiResult error(String... codes) {
        return new ErrorApiResult(codes);
    }

    /**
     * 创建错误返回体
     *
     * @param code 错误码
     * @param message  错误信息
     * @return
     */
    public static ApiResult error(String code, String message) {
        return new ErrorApiResult(code, message);
    }

    /**
     * 根据code获取message
     *
     * @param code
     * @return
     */
    protected String getMessageByCode(String code) {
        return SpringPropertyUtil.getValueWithDefault(code, code);
    }

}
