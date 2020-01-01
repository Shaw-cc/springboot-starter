# 使用文档

* [使用文档](#%E4%BD%BF%E7%94%A8%E6%96%87%E6%A1%A3)
  * [<g\-emoji class="g\-emoji" alias="cherries" fallback\-src="https://github\.githubassets\.com/images/icons/emoji/unicode/1f352\.png">🍒</g\-emoji> 打印方法执行日志](#cherries-%E6%89%93%E5%8D%B0%E6%96%B9%E6%B3%95%E6%89%A7%E8%A1%8C%E6%97%A5%E5%BF%97)
    * [功能介绍](#%E5%8A%9F%E8%83%BD%E4%BB%8B%E7%BB%8D)
    * [功能配置](#%E5%8A%9F%E8%83%BD%E9%85%8D%E7%BD%AE)
    * [使用方式](#%E4%BD%BF%E7%94%A8%E6%96%B9%E5%BC%8F)
    * [使用示例](#%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B)
  * [<g\-emoji class="g\-emoji" alias="cherries" fallback\-src="https://github\.githubassets\.com/images/icons/emoji/unicode/1f352\.png">🍒</g\-emoji> 读取Spring容器内属性](#cherries-%E8%AF%BB%E5%8F%96spring%E5%AE%B9%E5%99%A8%E5%86%85%E5%B1%9E%E6%80%A7)
    * [功能介绍](#%E5%8A%9F%E8%83%BD%E4%BB%8B%E7%BB%8D-1)
    * [功能配置(可选)](#%E5%8A%9F%E8%83%BD%E9%85%8D%E7%BD%AE%E5%8F%AF%E9%80%89)
    * [使用方式](#%E4%BD%BF%E7%94%A8%E6%96%B9%E5%BC%8F-1)
    * [使用示例](#%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B-1)

* [gh-md-toc](#:cherries: 读取Spring容器内属性)

## :cherries: 打印方法执行日志

### 功能介绍

打印方法的入参、返回值、执行时间、异常信息等信息

### 功能配置

```yaml
base:
  log:
    enabled: true # 开启方法执行信息收集功能
    time-pattern: yyyy-MM-dd HH:mm:ss # 配置方法信息中时间的格式
```

### 使用方式

* 使用默认实现[DefaultLogAspect.java](../src/main/java/com/kimzing/base/log/impl/DefaultLogAspect.java)，打印方法执行信息

在需要进行日志打印的方法上加上`@LogKim(desc = "示例")`注解即可，方法执行时将会在控制台打印对应的执行信息。desc为该方法的描述信息，建议填写。

```java
public class Demo {
    @LogKim(desc = "示例方法")
    public String method() {
        return "hello";
    }
}
```

* 自定义对方法执行信息的处理方式

编写自定义的容器类，继承`LogAspect`, 实现`handleLogInfo(LogInfo logInfo)`方法，`LogInfo`为对应的方法执行信息。
handleLogInfo方法中可以进行自定义处理，例如对方法执行信息进行持久化、落库、分析等。

```java
@Component
public class JsonLogAspect extends LogAspect {

    @Override
    public void handleLogInfo(LogInfo logInfo) {
        sendToES(logInfo);
    }
}
```

### 使用示例

自定义处理类: 使用Json格式进行日志打印: [JsonLogAspect](../../src/base-springboot-starter-test/src/main/java/com/kimzing/test/config/log/JsonLogAspect.java)

方法标记示例: [UserController](../../src/base-springboot-starter-test/src/main/java/com/kimzing/test/controller/UserController.java)

## :cherries: 读取Spring容器内属性

### 功能介绍

读取Spring容器内属性，包含`application-*.yml`、@PropertySource加载的所有Spring属性，通过`key`获取`value`

### 功能配置(可选)

自定义需要加载的配置文件, 配置文件中的属性将会被装入Spring容器属性中。

```yaml
base:
  property:
    files: ["message.properties","exception.properties"]
```

### 使用方式

```java
public class SpringPropertyUtilTest {

    /**
     * 获取容器内属性，如果不存在，返回null
     */
    public void testGetPropertyWhenKeyIsNotExist() {
        String value = SpringPropertyUtil.getValue("1001");
        // value = "test-message"

        String value = SpringPropertyUtil.getValue("not-exist");
        // value = null

        String defaultValue = "default message";
        String value = SpringPropertyUtil.getValueWithDefault("not-exist", defaultValue);
        // value = "default message"
    }
}
```

### 使用示例

[SpringPropertyUtilTest](../../base-springboot-starter-test/src/test/java/com/kimzing/test/SpringPropertyUtilTest.java)

