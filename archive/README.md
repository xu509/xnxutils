# 归档物料
## 使用方式

1. 通过maven安装jar包至本地仓库
>调整至包目录下
>mvn install:install-file -Dfile=utils-0.0.1.jar -DgroupId=com.xuningxin -DartifactId=utils -Dversion=0.0.1 -Dpackaging=jar

2. 在pom中引用

```
<dependency>
 <groupId>com.xuningxin</groupId>
 <artifactId>utils</artifactId>
 <version>0.0.1</version>
</dependency>
```

