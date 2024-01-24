def signing = ["Release", "Debug", "Unsigned"]

pipeline {
    agent any

    stage{
   steps{
    checkout scmGit(branches:name'*/master',extensions:[],
    userRemoteConfigs:[[url:'https://github.com/fatihkurcenli/Jenkins-Test.git'])
   }
    }

    stage('BuildClean'){
    steps{
    sh 'gradle clean build'}}


    options {
        // Stop the build early in case of compile or test failures
        skipStagesAfterUnstable()
    }

    parameters {
        choice(
                name: 'Signing',
                choices: signing,
                description: 'Paketin imzalı, imzasız olması seçimidir'
        )
        booleanParam(
                name: 'SSL_PINNING_ENABLED',
                defaultValue: 'true',
                description: 'Test working'
        )
        choice(
                name: 'IS_TEST_BUILD',
                choices: 'false\ntrue',
                description: 'Uygulama test ortamlarında çalışacak ise TRUE, canlı ortamda çalışacak ise FALSE seçilmelidir.'
        )
    }


        stages {
            stage('Hello') {
                steps {
                    echo 'Hello World'
                }
            }
        }
}