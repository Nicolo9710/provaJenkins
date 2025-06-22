pipeline {
    agent any

    environment {
        TOMCAT_URL = 'http://localhost:8080'
        WAR_NAME = 'mia-app'
        TOMCAT_USER = 'tomcat'     // da sostituire con credenziali sicure!
        TOMCAT_PASS = 'tomcat'
    }

    tools {
        maven 'Maven 3.9.1'  // Nome esatto come configurato in "Gestione strumenti globali" di Jenkins
    }

    triggers {
        githubPush() // attiva la pipeline con push su GitHub
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Nicolo9710/provaJenkins.git'
            }
        }

        stage('Build con Maven') {
            steps {
                // Maven è nel PATH grazie al blocco tools
                bat 'mvn clean install -f pom.xml'
            }
        }

        stage('Deploy su Tomcat') {
            steps {
                script {
                    def warFile = findFiles(glob: '**/*.war')[0].path
                    def contextPath = WAR_NAME

                    echo "Deploying ${warFile} to ${TOMCAT_URL}/${contextPath}"

                    bat """
                        curl -v --upload-file "${warFile}" --user "${TOMCAT_USER}:${TOMCAT_PASS}" "${TOMCAT_URL}/manager/text/deploy?path=/${contextPath}&update=true"
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Deploy riuscito!'
        }
        failure {
            echo 'Errore durante il build o il deploy.'
        }
    }
}
