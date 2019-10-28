def call(nextTag) {
     stage('deploy') {
        if (BRANCH_NAME.startsWith('master')) {
            tagIt(nextTag)
            sh 'mvn -DskipTests=true deploy'
        }
        else {
            sh 'mvn -DskipTests=true verify'
        }
    }
}
