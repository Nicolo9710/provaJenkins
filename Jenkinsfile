pipeline {
    agent any

    environment {
        registry = "nicolo9710/provajenkins"
        registryCredential = 'docker'
        dockerImage = ''
    }

    stages {
        stage('Cloning our Git') {
            steps {
                git branch: 'main', url: 'https://github.com/Nicolo9710/provaJenkins.git'
            }
        }

        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build(registry + ":$BUILD_NUMBER")
                }
            }
        }

        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build e push riusciti con successo.'
        }
        failure {
            echo 'Errore durante la pipeline.'
        }
    }
}
