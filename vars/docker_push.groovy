def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker build -t ${dockerhubuser}/${Project}:${ImageTag} ."
        sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }
}
