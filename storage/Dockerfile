FROM adoptopenjdk/openjdk8:x86_64-alpine-jre8u232-b09
#FROM adoptopenjdk/openjdk8:alpine-jre
ARG JAR_FILE=target/storage-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]