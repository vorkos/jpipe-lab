# jpipe-lab
jenkins pipeline lab

Webhook triggering example - curl -vs -X POST -H "Content-Type: application/json" -d '{ "branch": "trunk" }' http://username:password@${JENKINS_URL}/generic-webhook-trigger/invoke?token=${TOKEN} 2>&1


#security approvals requred
${JENKINS_URL}/scriptApproval/ - 
method hudson.plugins.git.GitSCM getUserRemoteConfigs
method hudson.plugins.git.GitSCM isDoGenerateSubmoduleConfigurations
method hudson.plugins.git.GitSCMBackwardCompatibility getExtensions


#Main job - parameterized pipeline job from SCM
BRANCH - is string parameter. 
The webhook is configured with "Generic Webhook Trigger" - 
        $.branch expresion and BRANCH - variable name. 

Token set in "Trigger builds remotely (e.g., from scripts)" 


#Childs
Jobs "users" and "iptables" set as parameterized pipeline jobs from SCM