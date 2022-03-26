
def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'Dockerhub-Credentails', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t mabdelfatah/mma-demo:java-maven-app-v1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push mabdelfatah/mma-demo:java-maven-app-v1'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
