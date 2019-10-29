def call(nextTag) {
    log.info "TAG IT"
    
    if (env.BRANCH_NAME.startsWith('master')) {
      log.info "MASTER BRANCH"
    }
    if (env.BRANCH_NAME.startsWith('develop')) {
      log.info "DEVELOP BRANCH"
    }
}
