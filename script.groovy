#!/usr/bin/env groovy

def versionIncrement() {

                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"

}

def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'Dockerhub-Credentails', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t mabdelfatah/mma-demo:${IMAGE_NAME} ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push mabdelfatah/mma-demo:${IMAGE_NAME}"
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
