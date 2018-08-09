# 远方旅游助手

## 建立数据库

``` mysql
create user distance@localhost identified by '';
create database distance;
grant all privileges on distance.* to distance@localhost identified by '';
```

## 安装环境

``` bash
yum install java-1.8.0-openjdk-devel.x86_64
yum install maven
cd distance-backend
mvn -N io.takari:maven:wrapper
```




## 运行

``` bash
./mvnw spring-boot:run
```