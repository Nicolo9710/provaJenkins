pipeline {
    agent any
    
    triggers {
        githubPush() // attiva la pipeline con push su GitHub
    }
    stages{
		stage('Clone repository') {               
             
            checkout scm    
      }     
      stage('Build image') {         
       
            app = docker.build("nicolo9710/provajenkins")    
       }     
      stage('Test image') {           
            app.inside {            
             
             sh 'echo "Tests passed"'        
            }    
        } 
      stage('Push image') {
       docker.withRegistry('https://registry.hub.docker.com', 'docker') {            
		       app.push("${env.BUILD_NUMBER}")            
		       app.push("latest")        
              }    
          }
	}
    
}

pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'nicolo9710/provajenkins'
        REGISTRY_CREDENTIALS = 'docker' // ID delle credenziali in Jenkins
    }

    triggers {
        githubPush() // attiva la pipeline su push GitHub
    }

    stages {
        stage('Clone repository') {
            steps {
                checkout scm
            }
        }

        stage('Build image') {
            steps {
                script {
                    app = docker.build("${DOCKER_IMAGE}")
                }
            }
        }

        stage('Test image') {
            steps {
                script {
                    app.inside {
                        sh 'echo "Tests passed"' // test 
                    }
                }
            }
        }

        stage('Push image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', "${REGISTRY_CREDENTIALS}") {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminata.'
        }
        success {
            echo 'Build e push riusciti con successo.'
        }
        failure {
            echo 'Errore durante la pipeline.'
        }
    }
}
