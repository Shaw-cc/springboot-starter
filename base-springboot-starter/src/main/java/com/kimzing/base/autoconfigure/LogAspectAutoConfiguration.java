package com.kimzing.base.autoconfigure;

import com.kimzing.base.autoconfigure.properties.LogProperties;
import com.kimzing.base.log.LogAspect;
import com.kimzing.base.log.impl.DefaultLogAspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志切面自动配置.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/26 10:53
 */
@Configuration
@EnableConfigurationProperties({LogProperties.class})
@ConditionalOnProperty(prefix = "base.log", name = "enabled",
        havingValue = "true")
@ConditionalOnClass(Aspect.class)
@ConditionalOnMissingBean(LogAspect.class)
public class LogAspectAutoConfiguration {

    /**
     * 日志
     *
     * @param logProperties
     * @return
     */
    @Bean
    public LogAspect logAspect(LogProperties logProperties) {
        DefaultLogAspect defaultLogAspect = new DefaultLogAspect();
        return defaultLogAspect;
    }

}
