# 远方旅游助手

# 建立数据库

``` mysql
create user distance@localhost identified by '';
create database distance;
grant all privileges on distance.* to distance@localhost identified by '';
```

## 运行

``` bash
./mvnw spring-boot:run
```