FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} employeeservice.jar

ENTRYPOINT ["java","-jar","/employeeservice.jar"]

EXPOSE 9007