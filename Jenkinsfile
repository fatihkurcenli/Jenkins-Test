pipeline {
    agent any

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
                        sh "gradle clean"
                        echo "Branch name: ${env.BRANCH_NAME}"
                    }
                }

        stage('Build') {
            steps {
                script {
                    sh "gradle assembleDebug"
                }
            }
        }
        stage('Archive Artifacts') {
            steps {
                // APK dosyasını arşivle
                archiveArtifacts artifacts: '**/build/outputs/**/*.apk', fingerprint: true
            }
        }
    }
}