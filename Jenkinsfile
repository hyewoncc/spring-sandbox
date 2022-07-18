pipeline {
    agent any
    stage('git') {
        git(url: 'https://github.com/hyewoncc/spring-sandbox.git', branch: 'jenkins/test1')
    }
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
