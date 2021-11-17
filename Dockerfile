FROM openjdk:11

MAINTAINER iamoyemadeteepee@gmail.com

EXPOSE 40751

WORKDIR /usr/local/bin/

COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

ENV TZ=Africa/Lagos

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENTRYPOINT [ "sh", "-c", "java -jar app.jar"]