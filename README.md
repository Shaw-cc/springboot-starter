# base-springboot-starter

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

## 项目规约

## 项目使用

### 异常管理

### 日志打印

### 属性映射

### Api响应体

### 获取Spring容器属性

### 获取Spring上下文

## 关于更多

[更新记录](CHANGELOG.md)   [自制Starter](LEARN.md)