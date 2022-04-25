## abstract
-----------

Following best practices to build, test and deploy simple java-maven-application, we are going to work with jenkins as our CI tool.

### Jenkins Pipeline
Included functions:
- Auto-increment application version.
- test application with build tools like: maven 
- build app with docker
- deploy to a private repository: in dockerHUb 
- puplish to the server
- push newly changes to github repo.


### Jenkins Shared Library

Here is the Linked [ Jenkins Shared LIbraray ](https://github.com/mAbdelfatah11/Jenkins-Shared-Library)
Github repo contains all the Jobs groovy scripts for all stages that will be called later on the Jenkinsfile.

Each stage in the 'jenkinsfile' should have its own 'job.groovy' file in the shared library.
The shared library is already connected to the multi-branch pipeline in Jenkins server as a global component library.

### Process

- work started by creating two branches up from the main branch, in order to test pipeline stages job by job, as it can be used for learning purpose as well.
- A Complete Pipeline is developed to apply the whole CI functions as a basic pipeline responsible for building, testing and deploying a simple Java application.
- The Overall process should include basic startup processes such as creating [jenkinsfile](./Jenkinsfile), and proceeding through the creation of stages, then creating the acutal stage jobs in [ Jenkins Shared LIbraray ](https://github.com/mAbdelfatah11/Jenkins-Shared-Library), and link the Shared Library with Jenkins as a Global config. component.
