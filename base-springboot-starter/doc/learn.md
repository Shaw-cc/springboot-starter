# 使用文档

## :cherries: 收集方法执行的相关信息

### 功能介绍

收集方法的入参、返回值、执行时间、异常信息

### 功能配置

```yaml
base:
  log:
    enabled: true # 开启方法信息收集功能
    time-pattern: yyyy-MM-dd HH:mm:ss # 配置方法信息中时间的格式
```

### 使用方式

* 使用默认实现对方法执行信息进行打印

默认实现: [DefaultLogAspect.java](../src/main/java/com/kimzing/base/log/impl/DefaultLogAspect.java)

在需要进行信息收集的方法上加上`@LogKim(desc = "示例")`注解即可，方法执行时将会在控制台打印对应的执行信息。desc为该方法的描述信息，建议填写。

```java
public class Demo {
    @LogKim(desc = "示例方法")
    public String method() {
        return "hello";
    }
}
```

* 自定义对方法执行信息的处理方式

编写自定义的容器类，继承`LogAspect`, 实现`handleLogInfo(LogInfo logInfo)`方法，`LogInfo`为对应的方法日志信息，可以作自定义处理(持久化、落库、分析)。

```java
@Component
public class JsonLogAspect extends LogAspect {

    @Override
    public void handleLogInfo(LogInfo logInfo) {
        LogUtil.info("method exec: [{}]", JSON.toJSONString(logInfo));
    }
}
```

### 使用示例

自定义Json日志打印: [JsonLogAspect](../../src/base-springboot-starter-test/src/main/java/com/kimzing/test/config/log/JsonLogAspect.java)

方法标记: [UserController](../../src/base-springboot-starter-test/src/main/java/com/kimzing/test/controller/UserController.java)

## :cherries: 读取Spring容器内属性

### 功能介绍

读取Spring容器内属性，包含`application-*.yml`、@PropertySource加载的所有Spring属性，通过`key`获取`value`

### 功能配置

定义需要加载的配置文件, 指定的配置文件中的属性将会被装入Spring容器属性中。

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