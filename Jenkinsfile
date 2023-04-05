pipeline {
    agent any
    stages {
        stage('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Docker create') {
            steps {
                sh 'docker build -t spring-boot-docker .'
            }
        }

        stage('Deploy within docker compose') {
            steps {
                sh 'docker compose -f spring.docker.yml up -d'
            }
        }
    }
}