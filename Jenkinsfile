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
        /*
        stage('checkout scm') {
            steps {
                checkout scm
            }
        }*/
        stage('Build') {
            steps {
                echo 'test'
                echo "Branch is - ${params.BRANCH}"
            }
        }
        stage('users') {
            when {
                expression {
                sh(returnStatus: true, script: 'git diff origin/${params.BRANCH} --name-only $GIT_PREVIOUS_COMMIT $GIT_COMMIT | grep ".*users.*" > /dev/null') == 0
                }
            }
            steps {
                echo 'users'
            }
        }
        stage('iptables') {
            when {
                expression {
                sh(returnStatus: true, script: 'git diff origin/${params.BRANCH} --name-only $GIT_PREVIOUS_COMMIT $GIT_COMMIT | grep ".*iptables.*" > /dev/null') == 0
                }
            }
            steps {
                echo 'iptables'
            }
        }
    }
}