def call(tagPrefix) {
    log.info "Find the next tag matching ${tagPrefix}"
    def largestContractTag = sh (
        script: "git tag --list '${tagPrefix}.*' | sort  -t '.' -k1,1 -k2,2 -k3,3 -g | tail -n 1",
        returnStdout: true
    ).trim().tokenize('.')

    log.info "${largestContractTag}"
    
    if (largestContractTag)
      return largestContractTag.init().plus(largestContractTag.last().toInteger() + 1).join('.')
    
    log.info "No tag found matching ${tagPrefix}, try to find if there are any tags"
    def project = tagPrefix.tokenize('-').init().join('-')
    def largestTag = sh (
        script: "git tag --list '${project}*' | sort  -t '.' -k1,1 -k2,2 -k3,3 -g | tail -n 1",
        returnStdout: true
    ).trim().tokenize('.')
    
    if (largestTag) {
        log.info "There are no tags matching ${tagPrefix} but there are tags assume contract version bump and reset smallest version component to 1"
        return "${tagPrefix}.1"
    }
    
    log.info "No tags at all assume we are migrating from non tagging build process, use the build number"
    return "${tagPrefix}.${currentBuild.number}"
}
