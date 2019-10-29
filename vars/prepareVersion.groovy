def call() {
    log.info "PREPARE VERSION"
    stage('prepare') {
        try {
            milestone()
            log.info "READING POM"
            
            def pom = readMavenPom file: 'pom.xml'
            
            log.info "VERSION ${pom.version}"
            
            def contractVersion = pom.version.split(".999")[0]
            def tagPrefix = "${pom.artifactId}-${contractVersion}"
            
            log.info "From ${pom.version} on ${env.BRANCH_NAME} we have prefix ${tagPrefix}"
            
            def nextTag = nextTag(tagPrefix)
            pom.version = nextTag.tokenize('-').last() 
            pom.groupId = groupId(pom)

            writeMavenPom model: pom

            currentBuild.displayName = "${pom.version} #${currentBuild.number}"

            return nextTag
        } catch (Exception e) {
            log.info "ERROR - ${e}"
            throw e;
        }        
    }
}
