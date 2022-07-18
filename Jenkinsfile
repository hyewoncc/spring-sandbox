pipeline {
    agent any
    stages {
        stage('Permission') {
            steps {
                chmod +x ./gradlew
            }
        }
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
