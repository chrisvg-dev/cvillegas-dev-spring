pipeline {
    agent any

    stages {
        stage('Maven Build') {
            sh 'mvn clean install'
        }
    }
}