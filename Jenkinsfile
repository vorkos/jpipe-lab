pipeline {
    agent any
                /* 
                * initial 
                */
    parameters {
        string(name: 'BRANCH', defaultValue: 'default', description: 'Branch name')
    }
    triggers {
    GenericTrigger(
     genericVariables: [
      [key: 'BRANCH', value: '$.branch']
     ],
     causeString: 'Triggered on $BRANCH',
     regexpFilterExpression: '',
     regexpFilterText: '',
     printContributedVariables: true,
     printPostContent: true
    )
    }
    stages {
        stage('checkout scm') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo 'test'
                echo "Branch is - ${params.BRANCH}"
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