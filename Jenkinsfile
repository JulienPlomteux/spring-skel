@Library([
    'continuous-deployment-library@master',
    'shared-library@fix/julien'
]) _

continuousDeployment(
    config: [
        app: [
            name: 'nc-connector',
            group: 'plomteux',
            version_control: 'maven'
        ],
        strategy: [
            type: 'ONE_BRANCH'
        ],
        build: [
            builder: 'maven',
            builder_version: '3.8.5-openjdk-17',
            container: 'eclipse-temurin',
            container_template: 'openjdk',
            destination: 'target/*.jar'
        ],
        deploy: [],
        docker: []
    ]
)
