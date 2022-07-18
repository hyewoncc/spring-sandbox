pipeline {
    agent any
    stage('Permission') {
        chmod +x ./gradlew
    }
    stage('Build') {
        sh './gradlew build'
    }
    stage('Test') {
        sh './gradlew test'
    }
}
