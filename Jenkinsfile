pipeline {
    agent any

    options {
        // Stop the build early in case of compile or test failures
        skipStagesAfterUnstable()
    }

    stages {
        stage('Clean') {
         steps {
                            bat 'gradle clean'
                             echo "Branch name: ${params.BRANCH_NAME}"
                           }
                  steps {
                      // Compile the app and its dependencies
                     //sh "chmod +x gradlew"
                    //sh '.\gradlew build'
                      bat 'gradle build --status'
                      echo "Branch name: ${params.BRANCH_NAME}"
                    }
                }


        stage('Build') {
            agent any
                      /* when {
                               expression {
                                   return !(env.BRANCH_NAME ==~ /PR-\d+/)
                               }
                         } */
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
                echo "$WORKSPACE"
                echo "${env.WORKSPACE}"
                echo "${params.WORKSPACE}"
                //archiveArtifacts artifacts: '**//* build/outputs *//** /* *//*.apk', fingerprint: true
               archiveArtifacts artifacts: 'app/build/outputs/apk/debug/*.apk', fingerprint: true
            }
        }
    }
}