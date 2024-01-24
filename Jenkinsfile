pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Git repoyu çek
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Gradle ile projeyi derle
                script {
                    def gradleHome = tool 'Gradle'
                    def androidHome = tool 'Android_SDK'
                    sh "${gradleHome}/bin/gradle clean assembleDebug"
                }
            }
        }

        stage('Test') {
            steps {
                // Test aşamasını buraya ekleyin (isteğe bağlı)
                script {
                    def gradleHome = tool 'Gradle'
                    sh "${gradleHome}/bin/gradle test"
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