def cal(String url, String branch) {
  echo 'This is for cloning code'
  git url: "${url}", branch: "${branch}"
}
