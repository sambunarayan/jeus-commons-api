FROM eclipse-temurin:17-jdk-alpine
LABEL description="Jeus common api Application"
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} jeus-commons-api-1.0-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/jeus-commons-api-1.0-SNAPSHOT.jar" ]