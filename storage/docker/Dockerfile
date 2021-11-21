FROM adoptopenjdk/openjdk8:x86_64-alpine-jre8u232-b09
#ARG JAR_FILE=target/storage-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]