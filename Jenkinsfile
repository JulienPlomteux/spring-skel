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
//                 sh 'ls -al'
                sh 'mvn clean package'
            }
        }
    }
}