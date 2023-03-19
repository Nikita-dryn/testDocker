
FROM openjdk:19-jre-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=/build/libs/testDocker-0.0.1-SNAPSHOT-plain.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]