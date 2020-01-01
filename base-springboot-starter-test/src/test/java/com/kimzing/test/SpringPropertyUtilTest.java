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

    @Test
    public void testGetPropertyWhenSuccess() {
        String value = SpringPropertyUtil.getValue("1001");
        Assert.isTrue("test-message".equals(value), "读取信息失败");
    }

    @Test
    public void testGetPropertyWhenKeyIsNotExist() {
        String value = SpringPropertyUtil.getValue("not-exist");
        Assert.isTrue(value == null, "读取信息异常");
    }

    @Test
    public void testGetPropertyWithDefaultValueWhenKeyIsExist() {
        String defaultValue = "default message";
        String value = SpringPropertyUtil.getValueWithDefault("BASE_0001", defaultValue);
        Assert.isTrue("test-exception".equals(value), "信息读取失败");
    }

    @Test
    public void testGetPropertyWithDefaultValueWhenKeyIsNotExist() {
        String defaultValue = "default message";
        String value = SpringPropertyUtil.getValueWithDefault("not-exist", defaultValue);
        Assert.isTrue(defaultValue.equals(value), "默认信息读取失败");
    }

}
