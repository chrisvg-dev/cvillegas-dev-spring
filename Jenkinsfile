pipeline {
    agent any
    stages {
        stage('Maven Test') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn test'
                }                
            }
        }

        //stage('SonarQube Analysis') {
        //    steps {
        //        sh '/opt/maven/bin/mvn clean verify sonar:sonar -Psonar'
        //    }
       // }

        //stage('Setup HTTPS') {
        //   steps {
        //        sh 'cp /home/keystore.jks src/main/resources/keystore.jks'
        //    }
        //}

        stage('Maven Build') {
            steps {
                withMaven(maven: 'maven') {
                    sh 'mvn clean package -Pprod -DskipTests'
                }
                
            }
        }

        stage('Docker build') {
            steps {
                sh 'docker build -t cvillegas92/cvillegas-backend .'
            }
        }

        stage('Docker push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh 'docker push cvillegas92/cvillegas-backend'
                }
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
