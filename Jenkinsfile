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
                checkout([
                $class: 'GitSCM',
                branches: [[name: "*/${params.BRANCH}"]],
                doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                extensions: scm.extensions,
                userRemoteConfigs: scm.userRemoteConfigs
    ])
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
                expression {
                sh(returnStatus: true, script: "git diff --name-only HEAD~1..HEAD| grep '.*users.*' > /dev/null") == 0
                }
            }
            steps {
                build job: 'users', parameters: [[$class: 'StringParameterValue', name: 'BRANCH', value: BRANCH]]
            }
        }
        stage('iptables') {
            when {
                expression {
                sh(returnStatus: true, script: "git diff --name-only HEAD~1..HEAD| grep '.*iptables.*' > /dev/null") == 0
                }
            }
            steps {
                build job: 'iptables', parameters: [[$class: 'StringParameterValue', name: 'BRANCH', value: BRANCH]]
            }
        }
    }
}