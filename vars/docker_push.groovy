def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(credentialsId: 'DockerHubCred', passwordVariable: 'DOCKERHUB_PASS', usernameVariable: 'DOCKERHUB_USER')]) {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker build -t ${dockerhubuser}/${Project}:${ImageTag} ."
        sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
}
