#!/usr/bin/env groovy

//import com.cloudbees.hudson.plugins.modeling.*

@Library('Jenkins-Shared-Library')
def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    
    stages {
    
        stage('init') {
            steps {
                script {
                	gv = load "script.groovy"
                }
            }
        }
        
        stage('increment version') {
            steps {
                script {
                	versionIncrement()
                }
            }
        }
        stage('build app') {
            steps {
                script {
			buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
			buildImage()
			dockerLogin()
			dockerPush()
                }
            }
        }
        
        stage('deploy') {
            steps {
                script {
                    echo 'deploying docker image to EC2...'
                }
            }


        }
    }
}
