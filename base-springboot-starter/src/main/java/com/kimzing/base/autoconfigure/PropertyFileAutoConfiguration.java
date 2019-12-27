package com.kimzing.base.autoconfigure;

import com.kimzing.base.autoconfigure.properties.FileProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 配置文件自动加载配置.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/26 10:57
 */
@Configuration
@EnableConfigurationProperties({FileProperties.class})
@PropertySource(
        value = {"${base.property.files[0]}", "${base.property.files[1]}",
                "${base.property.files[2]}", "${base.property.files[3]}",
                "${base.property.files[4]}"},
        ignoreResourceNotFound = true,
        encoding = "UTF-8")
@ConditionalOnBean(value = Environment.class)
public class PropertyFileAutoConfiguration {

}
