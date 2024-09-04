FROM openjdk:21-jdk-alpine

WORKDIR /admin

COPY build/libs/inventory-0.0.1-SNAPSHOT.jar /inventory/inventory-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/inventory/inventory-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
