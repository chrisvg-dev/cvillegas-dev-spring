pipeline {
    agent any
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
                    echo "the container is running!"
                    else
                    docker compose -f spring.docker.yml up -d
                    fi
                '''
            }
        }
    }
}