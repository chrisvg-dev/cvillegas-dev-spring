pipeline {
    agent any
    stages {
        stage('Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Docker create') {
            steps {
                sh 'docker build -t spring-boot-docker .'
            }
        }
    }
}