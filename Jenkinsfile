pipeline {
    agent any

      parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH_NAME', type: 'PT_BRANCH'
      }

    options {
        // Stop the build early in case of compile or test failures
        skipStagesAfterUnstable()
    }

  stages {
    stage('branchler') {
      steps {
        git branch: "${params.BRANCH}", url: 'https://github.com/jenkinsci/git-parameter-plugin.git'
      }
    }
  }
    stages {



       stage('Clean') {
         steps {
                            bat 'gradle clean'
                             echo "Branch name: ${params.BRANCH_NAME}"
                           }
               /*   steps {
                      // Compile the app and its dependencies
                     //sh "chmod +x gradlew"
                    //sh '.\gradlew build'
                      bat 'gradle build --status'
                      echo "Branch name: ${params.BRANCH_NAME}"
                    } */
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