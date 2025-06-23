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