pipeline {
    agent any
                /* 
                * initial 
                */
    stages {
        stage('checkout scm') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo 'test'
                echo "Branch is - ${BRANCH_NAME}"
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