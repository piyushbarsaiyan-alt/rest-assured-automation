pipeline {
    agent any

    tools {
        jdk 'JDK21'      // <-- Use your exact JDK name
        maven 'Maven3'   // <-- Your Maven installation name
    }

    stages {

        stage('Checkout SCM') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                bat "mvn clean test"
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'D:\\Tool\\allure-2.35.1\\bin\\allure.bat generate -c -o allure-report'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'allure-report/**'
        }
    }
}
