pipeline {
    agent any
                /* 
                * initial 
                */
    options([
        pipelineTriggers([
        [$class: 'GenericTrigger',
            genericVariables: [
            [expressionType: 'JSONPath', key: 'branch', value: '$.branch']],
            printContributedVariables: true,
            printPostContent: true,
            regexpFilterText: '',
            regexpFilterExpression: ''
        ]
        ])
    ])
    stages {
        stage('checkout scm') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh '''
                echo 'test'
                echo $branch
                echo "Branch is - ${env.BRANCH_NAME}"
                '''
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