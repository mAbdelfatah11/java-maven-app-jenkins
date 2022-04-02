#!/usr/bin/env groovy

@Library('Jenkins-Shared-Library')
def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
      
        stage("init") {
          
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
      
        stage("versionIncrement") {
          
            steps {
                script {
                    versionIncrement()
                }
            }
        }
        
        stage("build jar") {
          
            steps {
                script {
                    buildJar()
                }
            }
        }
     
        stage("build image") {
             
            steps {
                script {
                    buildImage()
                }
            }
        }

        stage("deploy") {
             
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
