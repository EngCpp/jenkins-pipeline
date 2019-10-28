def call(pom) {
    log.info "GROUP ID"
    
    if (BRANCH_NAME.startsWith('master'))
        return pom.groupId.replace(".unstable.",".stable.")

    if (BRANCH_NAME.startsWith('develop'))
        return pom.groupId.replace(".stable.",".unstable.")

    return pom.groupId.replace(".stable.",".canary.").replace(".unstable.", ".canary.")
}
