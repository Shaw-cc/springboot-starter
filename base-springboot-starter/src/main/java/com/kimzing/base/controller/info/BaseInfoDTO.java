package com.kimzing.base.controller.info;

import lombok.Builder;
import lombok.Data;

/**
 * 项目信息.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/26 14:05
 */
@Data
@Builder
public class BaseInfoDTO {

    /**
     * 项目名称
     */
    private String application;

    /**
     * 项目端口
     */
    private String port;

    /**
     * 项目描述
     */
    private String desc;

    /**
     * 项目版本
     */
    private String version;

}
