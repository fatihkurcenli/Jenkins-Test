pipeline {
    agent any

    options {
        // Stop the build early in case of compile or test failures
        skipStagesAfterUnstable()
    }

    stages {

           stage('Checkout') {
                steps {
                    script {
                        checkout([$class: 'GitSCM',
                                  branches: [[name: 'master']],
                                  userRemoteConfigs: [[url: 'https://github.com/fatihkurcenli/Jenkins-Test.git']]])
                    }
                }
            }
    stage('Clean') {
        steps {
                        // Compile the app and its dependencies
                        //sh "chmod +x gradlew"
                       //sh '.\gradlew build'
                        bat 'gradle build'
                        echo "Branch name: ${env.BRANCH_NAME}"
                    }
                }

        stage('Build') {
            agent any
                      when {
                               expression {
                                   return !(env.BRANCH_NAME ==~ /PR-\d+/)
                               }
                         }
            steps {
                script {
                    echo "Branch name: ${env.BRANCH_NAME}"
                    bat "gradle assembleDebug"
                }
            }
        }
         stage('Archive Artifacts') {
            steps {
                // APK dosyasını arşivle
                //archiveArtifacts artifacts: '**//* build/outputs *//** /* *//*.apk', fingerprint: true
                archiveArtifacts artifacts: 'app/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }
}