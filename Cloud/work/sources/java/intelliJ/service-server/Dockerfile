FROM openjdk:17-jdk
LABEL authors="admin"
ARG JAR_FILE=./target/service-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} service-server.jar
ENTRYPOINT ["java", "-jar", "/service-server.jar"]