pipeline {
  agent any
  stages {
    stage('git') {
      steps {
        git(url: 'https://github.com/lilyevans/AndroidStarter', branch: 'master')
      }
    }
    stage('build') {
      steps {
        sh '''cd AndroidStarter
./gradlew build'''
      }
    }
  }
}