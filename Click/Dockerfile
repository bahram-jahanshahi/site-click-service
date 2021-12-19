FROM openjdk:17-jdk-alpine
ARG JAR_FILE=Click/target/Click-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} click.jar
ENTRYPOINT ["java", "-jar", "click.jar"]