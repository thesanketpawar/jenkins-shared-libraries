def call(String projectName, String imageTag, String dockerHubUser) {
    echo "🚀 Shared Library: Pushing Image to Docker Hub..."
    
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', 
                                      passwordVariable: 'dockerHubPass', 
                                      usernameVariable: 'dockerHubUser')]) {
        
        // 1. Docker Hub mein Login karo
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        
        // 2. Image ko correct user account ke sath tag karo
        sh "docker image tag notes:${imageTag} ${env.dockerHubUser}/${projectName}:${imageTag}"
        
        // 3. Image ko push karo (withCredentials ke andar hi hona chahiye)
        sh "docker push ${env.dockerHubUser}/${projectName}:${imageTag}"
    }
}
