# 使用文档

## :cherries: 1.方法执行日志信息处理

### 功能介绍

收集方法的入参、返回值、执行时间、异常信息

### 功能配置

```yaml
base:
  log:
    enabled: true # 开启日志打印功能
    time-pattern: yyyy-MM-dd HH:mm:ss # 配置日志中时间的打印格式
```

### 使用方式

* 使用默认实现的日志切面打印

默认实现: [DefaultLogAspect.java](../src/main/java/com/kimzing/base/log/impl/DefaultLogAspect.java)

在需要执行日志处理的方法上加上`@LogKim(desc = "示例")`注解即可，方法执行时将会在控制台打印对应的执行信息。
desc为该方法的描述信息，建议填写。

* 自定义对日志信息的处理方式

编写自定义的容器类，继承`LogAspect`, 实现`handleLogInfo(LogInfo logInfo)`方法，`LogInfo`为对应的方法日志信息，可以作自定义处理(持久化、落库、分析)。

### 使用示例

自定义Json日志打印: [JsonLogAspect](../../src/base-springboot-starter-test/src/main/java/com/kimzing/test/config/log/JsonLogAspect.java)

方法标记: [UserController](../../src/base-springboot-starter-test/src/main/java/com/kimzing/test/controller/UserController.java)

```bash
2020-01-01 16:23:42.894  INFO 12278 --- [nio-8080-exec-1] com.kimzing.base.utils.log.LogUtil       : method exec: 
[{"className":"UserController","desc":"新增用户","elapsedTimeInMilliseconds":191,"endTime":"2020-01-01 16:23:42:799",
"methodName":"save","params":{"UserDTO":{"age":25,"gender":"MAN","password":"123456","username":"kimzing"}},
"result":{"code":"0","data":{"age":25,"gender":"MAN","id":1,"password":"123456","username":"kimzing"},"msg":"SUCCESS",
"ts":1577867022799},"startTime":"2020-01-01 16:23:42:608"}]
```

## :cherries: 2.SpringPropertyUtil

### 功能介绍

读取Spring容器内属性，包含`application-*.yml`、@PropertySource加载的所有Spring属性

### 使用环境

SpringBoot-Web项目

### 使用示例

[SpringPropertyUtilTest](../../base-springboot-starter-test/src/test/java/com/kimzing/test/SpringPropertyUtilTest.java)