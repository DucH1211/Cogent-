FROM openjdk:17

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} cloud-gateway.jar

ENTRYPOINT ["java","-jar","/cloud-gateway.jar"]

EXPOSE 9005