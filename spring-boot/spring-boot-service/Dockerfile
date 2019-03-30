FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/libs libs
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]