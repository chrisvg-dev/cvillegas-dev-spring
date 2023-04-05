pipeline {
    agent {
        docker {
            image 'maven:3.8.3-openjdk-11'
            args '-v $HOME/.m2:/root/.m2 -v /usr/share/maven:/usr/share/maven'
        }
    }
    tools {
        maven 'maven'
    }
    stages {
        stage('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Docker Image') {
            steps {
                sh 'docker build -t spring-boot-docker .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''#!/bin/bash
                    if [ -n "$(docker ps -f "name=spring-boot-docker" -f "status=running" -q )" ]; then
                        echo "The container is running!"
                        docker stop spring-boot-docker
                        docker rm spring-boot-docker
                    fi
                    docker compose -f spring.docker.yml up -d
                '''
            }
        }
    }
}