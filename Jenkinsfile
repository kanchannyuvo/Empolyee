pipeline {
  agent {
    docker {
      image 'java:8'
      args '-p 8081:8081'
    }

  }
  stages {
    stage('build') {
      steps {
        sh 'mvn clean install'
      }
    }

    stage('Test') {
      steps {
        echo 'testing done'
      }
    }

  }
}