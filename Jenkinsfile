pipeline {
    agent any
    stages {
        stage('git') {
            steps {
                git(url: 'https://github.com/hyewoncc/spring-sandbox.git', branch: 'jenkins/test1')
            }
        }
        stage('permission') {
            steps {
                sh 'chmod +x ./gradlew'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }
}
