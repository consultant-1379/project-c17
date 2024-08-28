FROM openjdk:16-alpine3.13
COPY ./ ./
RUN apk update
RUN apk add curl
CMD ["java", "-jar", "target/javacode-0.0.1-SNAPSHOT.jar"]