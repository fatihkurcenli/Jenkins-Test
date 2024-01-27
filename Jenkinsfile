pipeline {
    agent any

      parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH_NAME', type: 'PT_BRANCH'
      }

    options {
        // Stop the build early in case of compile or test failures
        skipDefaultCheckout(true)
        skipStagesAfterUnstable()

    }

    stages {

           stage('Example') {
              steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/fatihkurcenli/Jenkins-Test.git'
              }
            }

    stage('Clean') {
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