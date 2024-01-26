pipeline {
    agent any

    stages {
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