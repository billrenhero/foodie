# Docker image for springboot file run
# VERSION 0.0.1
# Author: renmingyuan
# 基础镜像使用java
FROM williamyeh/java8
VOLUME /tmp
EXPOSE 8080
EXPOSE 3306
# 作者
MAINTAINER renmingyuan <billrenhero@sina.com>
# 将jar包添加到容器中并更名为foodie.jar
ADD foodie.jar foodie.jar 
ADD application.yml application.yml
# 运行jar包
ENTRYPOINT ["java","-jar","/foodie.jar", "--spring.config.location=/application.yml"]

