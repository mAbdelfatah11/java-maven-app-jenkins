#!/usr/bin/env groovy

@Library('Jenkins-Shared-Library')
def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    
    stages {
	//update your git repo with the new change
	stage('commit version update') {
            steps {
                script {
			versionCommit()
                    }
                }
            }
        }
        }



