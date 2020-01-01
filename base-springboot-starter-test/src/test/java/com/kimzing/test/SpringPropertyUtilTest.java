package com.kimzing.test;

import com.kimzing.base.utils.spring.SpringPropertyUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

/**
 * Spring容器属性读取测试.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/31 17:24
 */
@SpringBootTest
@ActiveProfiles("spring-property")
public class SpringPropertyUtilTest {

    /**
     * 获取容器内属性，如果不存在，返回null
     */
    @Test
    public void testGetPropertyWhenKeyIsNotExist() {
        String value1 = SpringPropertyUtil.getValue("1001");
        Assert.isTrue("test-message".equals(value1), "读取信息失败");

        String value2 = SpringPropertyUtil.getValue("not-exist");
        Assert.isTrue(value2 == null, "读取信息异常");
    }

    /**
     * 获取容器内属性，如果不存在，返回默认值
     */
    @Test
    public void testGetPropertyWithDefaultValueWhenKeyIsExist() {
        String defaultValue = "default message";
        String value1 = SpringPropertyUtil.getValueWithDefault("BASE_0001", defaultValue);
        Assert.isTrue("test-exception".equals(value1), "信息读取失败");

        String value2 = SpringPropertyUtil.getValueWithDefault("not-exist", defaultValue);
        Assert.isTrue(defaultValue.equals(value2), "默认信息读取失败");
    }

}
