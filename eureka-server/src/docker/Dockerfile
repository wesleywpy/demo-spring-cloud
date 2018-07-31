FROM java:8u111-jdk-alpine

MAINTAINER "wangp_yong@163.com"

COPY eureka-server.jar /eureka.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","/eureka.jar"]