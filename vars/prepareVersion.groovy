def call() {
    stage('prepare') {
        milestone()
        def pom = readMavenPom file: 'pom.xml'
        def contractVersion = pom.version.split(".999")[0]
        def tagPrefix = "${pom.artifactId}-${contractVersion}"
        if (BRANCH_NAME.startsWith('develop')) {
            tagPrefix = "unstable_${tagPrefix}"
        }
        log.info "From ${pom.version} on ${BRANCH_NAME} we have prefix ${tagPrefix}"
        def nextTag = nextTag(tagPrefix)
        pom.version = nextTag.tokenize('-').last() 

        pom.groupId = groupId(pom)
        
        writeMavenPom model: pom
        
        currentBuild.displayName = "${pom.version} #${currentBuild.number}"
        
        return nextTag
    }
}
