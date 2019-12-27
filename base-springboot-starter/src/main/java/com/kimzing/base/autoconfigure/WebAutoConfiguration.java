package com.kimzing.base.autoconfigure;

import com.kimzing.base.controller.advice.ExceptionAdvice;
import com.kimzing.base.controller.info.BaseInfoController;
import com.kimzing.base.controller.info.BaseInfoDTO;
import com.kimzing.base.properties.WebProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * RestTemplate自动配置.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/26 10:51
 */
@Configuration
@EnableConfigurationProperties({WebProperties.class})
@ConditionalOnClass(DispatcherServlet.class)
public class WebAutoConfiguration {

    private static final String DEFAULT_DESC = "default";
    private static final String DEFAULT_VERSION = "0.0.1";

    /**
     * 注入RestTemplate实例，用于Http接口调用
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    @ConditionalOnProperty(prefix = "base.web.restTemplate",
            name = "enabled", havingValue = "true")
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }


    /**
     * 信息接口
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "base.web.info",
            name = "enabled", havingValue = "true", matchIfMissing = true)
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.ANY)
    public BaseInfoController infoController(WebProperties webProperties, Environment environment) {
        BaseInfoController baseInfoController = new BaseInfoController();
        baseInfoController.setBaseInfoDTO(getInfoDTO(webProperties, environment));
        return baseInfoController;
    }

    @Bean
    @ConditionalOnProperty(prefix = "base.web.advice",
    name = "enabled", havingValue = "true")
    @ConditionalOnMissingBean(ExceptionAdvice.class)
    public ExceptionAdvice exceptionAdvice() {
        return new ExceptionAdvice();
    }

    /**
     * 拼装/info信息
     *
     * @param webProperties
     * @param environment
     * @return
     */
    private BaseInfoDTO getInfoDTO(WebProperties webProperties, Environment environment) {
        BaseInfoDTO.BaseInfoDTOBuilder builder = BaseInfoDTO.builder();
        builder.application(environment.getProperty("spring.application.name"))
                .port(environment.getProperty("server.port"));

        if (webProperties.getInfo() == null) {
            builder.desc(DEFAULT_DESC)
                    .version(DEFAULT_VERSION);
            return builder.build();
        }

        String descTemp = webProperties.getInfo().getDesc();
        String desc = StringUtils.isBlank(descTemp) ? DEFAULT_DESC : descTemp;

        String versionTemp = webProperties.getInfo().getVersion();
        String version = StringUtils.isBlank(versionTemp) ? DEFAULT_VERSION : versionTemp;

        BaseInfoDTO baseInfoDTO = builder.desc(desc)
                .version(version).build();

        return baseInfoDTO;
    }

}
