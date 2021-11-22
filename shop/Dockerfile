FROM adoptopenjdk/openjdk8:x86_64-alpine-jre8u232-b09
ARG JAR_FILE=target/shop-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} shop.jar
ENTRYPOINT ["java", "-jar", "shop.jar"]