def call() {
    log.info "CHECKOUT WITH TAGS"
    checkout([
        $class: 'GitSCM',
        branches: scm.branches,
        doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
        extensions: [[$class: 'CloneOption', noTags: false, shallow: false, depth: 0, reference: '']],
        userRemoteConfigs: scm.userRemoteConfigs,
    ])
    sh "git config user.name engcpp"
    sh "git config user.email carlos@engcpp.com"
}
