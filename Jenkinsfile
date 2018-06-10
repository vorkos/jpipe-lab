pipeline {
    agent any
                /* 
                * initial 
                */
    triggers {
    GenericTrigger(
     genericVariables: [
      [key: 'branch', value: '$.branch']
     ],
     causeString: 'Triggered on $branch',
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
                sh "echo $branch"
                echo "Branch is - ${env.BRANCH_NAME}"
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