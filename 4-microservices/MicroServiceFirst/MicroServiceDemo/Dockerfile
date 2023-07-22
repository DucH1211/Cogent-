FROM openjdk:17

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} DepartmentMicroservice.jar

ENTRYPOINT ["java","-jar","/DepartmentMicroservice.jar"]

EXPOSE 9003