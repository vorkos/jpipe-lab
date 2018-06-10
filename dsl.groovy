def project = "vorkos/jpipe-lab"
def jobName = "${project}".replaceAll('/','-')
def token = "test2"
def users = "users"
def iptables = "iptables"

pipelineJob(jobName) {
    authenticationToken(token)
    definition {
        cpsScm {
            scm {
                git("https://github.com/${project}.git")
                scriptPath('Jenkinsfile')
            }
        }
    }
    triggers {
        genericTrigger {
        genericVariables {
            genericVariable {
            key("BRANCH")
            value("\$.branch")
            expressionType("JSONPath") //Optional, defaults to JSONPath
            regexpFilter("") //Optional, defaults to empty string
            defaultValue("") //Optional, defaults to empty string
            }
        }
        printContributedVariables(true)
        printPostContent(true)
        regexpFilterText("")
        regexpFilterExpression("")
        }
    }
    parameters {
        stringParam('BRANCH', '')
    }
}

pipelineJob(users) {
    parameters {
        stringParam("BRANCH", '')
    }
    definition {
        cpsScm {
            scm {
                git("https://github.com/${project}.git",'refs/heads/${BRANCH}')
                scriptPath("plays/${users}/Jenkinsfile")
            }
        }
    }
}

pipelineJob(iptables) {
    parameters {
        stringParam('BRANCH', '')
    }
    definition {
        cpsScm {
            scm {
                git("https://github.com/${project}.git",'refs/heads/${BRANCH}')
                scriptPath("plays/${iptables}/Jenkinsfile")
            }
        }
    }

}