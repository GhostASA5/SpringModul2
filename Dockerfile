FROM openjdk:17-oracle

WORKDIR /app

COPY build/libs/modul2homework-0.0.1-SNAPSHOT.jar app.jar

ENV CREATE_ON_START=true

CMD ["java", "-jar", "app.jar"]
