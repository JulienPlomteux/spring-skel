pipeline {
    agent {
        node{
            label 'docker-agent-alpine'
        }
    }
    triggers {
        pollSCM 'H/5 * * * *'
    }
    tools {
        maven 'maven-3.6.3'
    }
    environment {
        DATE = new Date().format('yy.M')
        TAG = "${DATE}.${BUILD_NUMBER}"
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    stage('Docker Build') {
        steps {
            script {
                docker.build("jcicd/springskel:${TAG}")
            }
        }
    }
    stage('Pushing Docker Image to Dockerhub') {
        steps {
            script {
                docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                    docker.image("jcicd/springskel:${TAG}").push()
                    docker.image("jcicd/springskel:${TAG}").push("latest")
                }
            }
        }
    }
    stage('Deploy'){
        steps {
            sh "docker stop hello-world | true"
            sh "docker rm hello-world | true"
            sh "docker run --name hello-world -d -p 9004:8080 vigneshsweekaran/hello-world:${TAG}"
        }
    }
}