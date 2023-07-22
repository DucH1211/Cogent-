FROM openjdk:17-ea-jdk-alpine
EXPOSE 9009
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} AssignmentSpringBoot.jar
ENTRYPOINT ["java","-jar","/AssignmentSpringBoot.jar"]