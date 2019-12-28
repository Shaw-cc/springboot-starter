package com.kimzing.base.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * web相关配置
 */
@Data
@ConfigurationProperties(prefix = "base.web", ignoreUnknownFields = true)
public class WebProperties {

    /**
     * RestTemplate属性配置
     */
    private RestTemplateProperties restTemplate;

    /**
     * Info接口信息
     */
    private InfoProperties info;

    /**
     * Controller异常切入
     */
    private AdviceProperties advice;

    @Data
    public static class AdviceProperties {
        /**
         * 异常Advice开关
         */
        private Boolean enabled;

    }

    @Data
    public static class InfoProperties {
        /**
         * Info接口开关
         */
        private Boolean enabled;

        private Map<String, Object> params;
    }

    @Data
    public static class RestTemplateProperties {
        /**
         * RestTemplate开关
         */
        private Boolean enabled;
    }

}