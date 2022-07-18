pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew bootJar'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
