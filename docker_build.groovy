def call(String projectName, String imageTag, String dockerHubUser) {
    echo "🐳 Shared Library: Building Image -> ${dockerHubUser}/${projectName}:${imageTag}"
    sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} ."
}
