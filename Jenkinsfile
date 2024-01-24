def signing = ["Release", "Debug", "Unsigned"]

pipeline {
    agent any

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