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
                sh 'docker compose -f spring.docker.yml up -d'
            }
        }
    }
}