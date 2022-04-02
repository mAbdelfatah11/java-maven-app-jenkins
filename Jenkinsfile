#!/usr/bin/env groovy

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
                	gv.versionIncrement()
                }
            }
        }
        stage('build app') {
            steps {
                script {
			gv.buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
			gv.buildImage()
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
