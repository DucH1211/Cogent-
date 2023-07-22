FROM openjdk:17
EXPOSE 5011
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} docker.jar
ENTRYPOINT ["java","-jar","/docker.jar"]