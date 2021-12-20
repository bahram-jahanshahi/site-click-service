FROM openjdk:17
ARG JAR_FILE=target/Click-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} click.jar
ENTRYPOINT ["java", "-jar", "click.jar"]
EXPOSE 9091