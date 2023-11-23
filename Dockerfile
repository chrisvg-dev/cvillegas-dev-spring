FROM openjdk:17-jdk-slim
ADD target/cvillegas.jar /opt/apps/cvillegas/cvillegas.jar
WORKDIR /opt/apps/cvillegas
ENTRYPOINT ["java","-jar","cvillegas.jar"]