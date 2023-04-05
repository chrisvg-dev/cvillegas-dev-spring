FROM adoptopenjdk/openjdk11
MAINTAINER cvillegas-dev.com
COPY /var/lib/jenkins/workspace/SpringDockerJob/target/MainApp-0.0.1-SNAPSHOT.jar MainApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/MainApp-0.0.1-SNAPSHOT.jar"]