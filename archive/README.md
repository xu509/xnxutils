# 归档物料
## 使用方式

1. 通过maven安装jar包至本地仓库
>mvn install:install-file -Dfile=***jar地址*** -DgroupId=com.xuningxin -DartifactId=utils -Dversion=0.1.1 -Dpackaging=jar

2. 在pom中引用

```
<dependency>
 <groupId>com.xuningxin</groupId>
 <artifactId>utils</artifactId>
 <version>0.1.1</version>
</dependency>
```

