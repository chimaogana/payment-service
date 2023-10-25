#define base docker image
FROM openjdk:17
ADD target/payment-service-0.0.1-SNAPSHOT.jar payment-service.jar
ENTRYPOINT ["java", "-jar","payment-service.jar"]