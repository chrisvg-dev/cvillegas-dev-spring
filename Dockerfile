# Choose java 11 as base image
FROM openjdk:11-jdk-slim
ADD target/cvillegas.jar /opt/apps/cvillegas/cvillegas.jar
WORKDIR /opt/apps/cvillegas
ENTRYPOINT ["java","-jar","cvillegas.jar"]