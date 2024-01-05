FROM openjdk:17-jdk-slim
ADD target/cvillegas.jar /opt/apps/cvillegas/cvillegas.jar
WORKDIR /opt/apps/cvillegas
EXPOSE 9192
ENTRYPOINT ["java","-jar","cvillegas.jar"]