FROM adoptopenjdk/openjdk11
MAINTAINER cvillegas-dev.com
COPY /var/lib/jenkins/.m2/repository/com/cvillegas/app/MainApp/0.0.1-SNAPSHOT/MainApp-0.0.1-SNAPSHOT.jar MainApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/MainApp-0.0.1-SNAPSHOT.jar"]