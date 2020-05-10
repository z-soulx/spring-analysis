FROM java:8
EXPOSE 8080
ARG JAR_FILE
ADD target/${JAR_FILE} /waiter-service2.jar
ENTRYPOINT ["java", "-jar","/waiter-service2.jar"]