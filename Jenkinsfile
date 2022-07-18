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
                ./gradlew bootJar
            }
        }
        stage('Test') {
            steps {
                ./gradlew test
            }
        }
    }
}
