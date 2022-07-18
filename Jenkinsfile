pipeline {
    agent any
    stages {
        stage('git') {
            steps {
                git(url: 'https://github.com/hyewoncc/spring-sandbox.git', branch: 'jenkins/test1')
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
