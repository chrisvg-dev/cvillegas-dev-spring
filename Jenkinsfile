pipeline {
    agent any
    stages {
        stage('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Clean docker') {
            steps {
                sh 'docker stop spring-boot-docker'
                sh 'docker rm spring-boot-docker'
            }
        }

        stage('Docker create') {
            steps {
                sh 'docker build -t spring-boot-docker .'
            }
        }

        stage('Deploy within docker') {
            steps {
                sh 'docker run --name backend -p 9191:8080 spring-boot-docker'
            }
        }
    }
}