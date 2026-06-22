def call(String repoUrl, String branchName) {
    echo "📥 Shared Library: Cloning repo from branch: ${branchName}"
    git url: repoUrl, branch: branchName
}
