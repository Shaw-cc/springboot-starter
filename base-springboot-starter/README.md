# :cn:  base-springboot-starter

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg?label=license)](https://github.com/KimZing/base-springboot-starter/blob/master/LICENSE)

## 项目简介

基于SpringBoot Starter封装的基础起步依赖，主要包含常用工具类、日志及其它自动化配置, 提供对应的切入点进行个性化配置



## 快速开始

首先在`pom.xml`中引入私有仓库地址

```xml
<repositories>
    <!--使用snapshot版本-->
    <repository>
        <id>KimZing-SNAPSHOT</id>
        <name>KimZing</name>
        <url>http://mvn.kimzing.com/nexus/content/repositories/snapshots/</url>
    </repository>
    <!--使用release版本-->
    <repository>
        <id>KimZing-RELEASE</id>
        <name>KimZing</name>
        <url>http://mvn.kimzing.com/nexus/content/repositories/releases/</url>
    </repository>
</repositories>
```

然后引入如下依赖刷新即可

```xml
<dependency>
    <groupId>com.kimzing</groupId>
    <artifactId>base-springboot-starter</artifactId>
    <version>${version}</version>
</dependency>
```

:eyes:[RELEASE版本](http://mvn.kimzing.com/nexus/content/repositories/releases/com/kimzing/base-springboot-starter/)  

:eyes:[SNAPSHOT版本](http://mvn.kimzing.com/nexus/content/repositories/snapshots/com/kimzing/base-springboot-starter/)



## 结构说明

```bash
└── base
    ├── autoconfigure     # springboot自动配置类
    │   └── properties    # 自动装配的属性类
    ├── exception         # 自定义异常
    ├── log               # 方法日志切面配置
    │   └── impl          # 日志切面默认实现
    ├── utils             # 通用工具类
    │   ├── spring        # 与spring容器相关的工具类
    │   └── ...           # 相对独立的工具类，可以脱离spring项目使用
    └── web               # springboot-web相关自动配置
        ├── advice        # controller异常切面处理
        └── info          # 项目基础信息 /info 接口配置
```



## 项目规约

### 版本

* 版本采用x.y.z的规约进行命名，release版本使用`-RELEASE`标记，snapshot版本使用`-SNAPSHOT`标记。
* master分支为当前最新功能分支
* 不同的版本切出不同的分支进行记录

### 扩展性

* 所有针对SpringBoot做的自动化配置必须做到可关闭，可扩展

### 可用性

* 相应`*-springboot-starter`必须在对应的`*-springboot-starter-test`项目进行标准测试



## 项目使用

:green_book:[SpringBoot相关配置工具使用介绍](base-springboot-starter/spring.md)   :blue_book:[通用工具使用介绍 ](base-springboot-starter/spring.md)

## 关于更多

[:bus:更新记录](../CHANGELOG.md)  :bus:[自制Starter](LEARN.md)

## 赞助

如果你喜欢此项目并且它对你确实有帮助，欢迎给我打赏一杯:coffee:~        *just for fun ~*

**支付宝**      <img src="alipay.png" alt="aaa" style="align:left;zoom:30%;" />

**微信**        <img src="wechatpay.png" alt="aaa" style="align:left;zoom:30%;" />