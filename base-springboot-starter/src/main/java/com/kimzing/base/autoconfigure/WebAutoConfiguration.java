package com.kimzing.base.autoconfigure;

import com.kimzing.base.autoconfigure.properties.WebProperties;
import com.kimzing.base.web.advice.ExceptionAdvice;
import com.kimzing.base.web.info.BaseInfoController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
            name = "enabled", havingValue = "true")
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.ANY)
    public BaseInfoController infoController(WebProperties webProperties) {
        BaseInfoController baseInfoController = new BaseInfoController();
        baseInfoController.setInfoMap(webProperties.getInfo().getParams());
        return baseInfoController;
    }

    @Bean
    @ConditionalOnProperty(prefix = "base.web.advice",
    name = "enabled", havingValue = "true")
    @ConditionalOnMissingBean(ExceptionAdvice.class)
    public ExceptionAdvice exceptionAdvice() {
        return new ExceptionAdvice();
    }

}
