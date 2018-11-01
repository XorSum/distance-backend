# 远方旅游助手

## 建立数据库

``` mysql
create user distance@localhost identified by '';
create database distance;
grant all privileges on distance.* to distance@localhost identified by '';
```

* 修改了数据库的账户名，密码等配置后，请修改配置文件src/main/resources/application.yml中相应的信息

## 安装环境

``` bash
yum install java-1.8.0-openjdk-devel
yum install maven
cd distance-backend
mvn -N io.takari:maven:wrapper
```

## 创建目录


``` bash
sudo mkdir /distance
sudo chmod 777 /distance
```

* 项目默认使用/distance ,如果想使用其它目录，请修改配置文件src/main/resources/application.yml中的file.uploadDir


## 运行

``` bash
./mvnw spring-boot:run 
```

后台运行

``` bash
setsid ./mvnw spring-boot:run 
```