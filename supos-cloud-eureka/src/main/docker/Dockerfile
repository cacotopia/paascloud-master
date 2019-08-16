FROM openjdk:8-jdk-alpine
MAINTAINER cacotopia <cacotopia@126.com>
VOLUME /tmp
ADD supos-cloud-eureka.jar /app/supos-cloud-eureka.jar
RUN sh -c 'touch /app/supos-cloud-eureka.jar'
ENV JAVA_OPTS=""
WORKDIR /app/
EXPOSE 8761
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/paascloud-eureka.jar" ]
