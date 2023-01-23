FROM openjdk:latest
COPY  ./target/agentapplication-0.0.1-SNAPSHOT.jar agentapplication.jar
CMD ["java","-jar","/agentapplication.jar"]