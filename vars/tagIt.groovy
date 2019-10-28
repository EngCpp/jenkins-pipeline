def call(nextTag) {
    log.info "TAG IT"
    
    if (BRANCH_NAME.startsWith('master')) {
      log.info "MASTER BRANCH"
    }
    if (BRANCH_NAME.startsWith('develop')) {
      log.info "DEVELOP BRANCH"
    }
}
