package com.kimzing.base.utils.result;

import com.kimzing.base.utils.spring.SpringPropertyUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * 通用返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/4 15:04
 */
public abstract class ApiResult {

    public Long ts;

    public String code;

    public String msg;

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
     * @param code 错误码
     * @return
     */
    public static ApiResult error(String code) {
        return new ErrorApiResult(code);
    }

    /**
     * 创建错误返回体
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return
     */
    public static ApiResult error(String code, String msg) {
        return new ErrorApiResult(code, msg);
    }

    /**
     * 根据code获取msg
     *
     * @param code
     * @return
     */
    protected String getMessageByCode(String code) {
        String message = SpringPropertyUtil.getValue(code);
        if (StringUtils.isNotBlank(message)) {
            return message;
        }
        return code;
    }

}
