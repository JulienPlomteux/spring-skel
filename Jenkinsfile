pipeline {
    agent {
        node{
            label 'jenkins-agent'
        }
    }
    triggers {
        pollSCM 'H/5 * * * *'
    }
    tools {
        maven 'maven-3.6.3'
    }

    stages {
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
