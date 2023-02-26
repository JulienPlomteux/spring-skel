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
      stage("build & SonarQube analysis") {
        agent any
        steps {
          withSonarQubeEnv('sonarqube') {
            sh 'mvn clean package sonar:sonar'
          }
        }
      }
      stage("Quality Gate") {
        steps {
          timeout(time: 1, unit: 'HOURS') {
            waitForQualityGate abortPipeline: true
          }
        }
      }
    }
}
