pipeline {
    agent any
    stage('Permission') {
        chmod +x './gradlew'
    }
    stage('Build') {
        sh './gradlew bootJar'
    }
    stage('Test') {
        sh './gradlew test'
    }
}
