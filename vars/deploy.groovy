def call(nextTag) {
      log.info 'DEPLOY'

     stage('deploy') {
        if (env.BRANCH_NAME.startsWith('master')) {
            tagIt(nextTag)
            sh 'mvn -DskipTests=true deploy'
        }
        else {
            sh 'mvn -DskipTests=true verify'
        }
    }
}
