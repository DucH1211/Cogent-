FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} EmployeeService.jar

ENTRYPOINT ["java","-jar","/EmployeeService.jar"]

EXPOSE 9002