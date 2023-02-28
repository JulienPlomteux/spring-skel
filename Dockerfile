#
# Build stage #
#docker pull maven:3.8.7-eclipse-temurin-11-alpine
FROM maven:3.8.7-eclipse-temurin-19-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:19-jre-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
