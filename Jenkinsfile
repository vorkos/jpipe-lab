pipeline {
    agent any
                /* 
                * initial 
                */
    echo "Branch is - ${env.BRANCH_NAME}"
    stages {
        stage('checkout scm') {
            steps {
                checkout scm
            }
        stage('Build') {
            steps {
                echo 'test'
            }
        }
        stage('users') {
            when {
                changeset 'users/*'
            }
            steps {
                echo 'users'
            }
        }
        stage('iptables') {
            when {
                changeset 'iptables/*'
            }
            steps {
                echo 'iptables'
            }
        }
    }
}