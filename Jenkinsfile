#!/usr/bin/env groovy

@Library('Jenkins-Shared-Library')
def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    
    stages {
        //auto increment built artifact version 
        stage('increment version') {
            steps {
                script {
                	versionIncrement()
                }
            }
        }
        //build the Artifact
        stage('build app') {
            steps {
                script {
			buildJar()
                }
            }
        }
        //build Docker image - DockerHublogin - Push image to DockerHUb
        stage('build image') {
            steps {
                script {
			buildImage()
                }
            }
        }
        //simulate deploy
        stage('deploy') {
            steps {
                script {
                    echo 'deploying docker image to EC2...'
                    deployToEC2()
                }
            }
            }
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



