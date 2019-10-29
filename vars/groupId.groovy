def call(pom) {
    log.info "GROUP ID - BRANCH: ${env.BRANCH_NAME}"
    
    if (env.BRANCH_NAME.startsWith('master'))
        return pom.groupId.replace(".unstable.",".stable.")

    if (env.BRANCH_NAME.startsWith('develop'))
        return pom.groupId.replace(".stable.",".unstable.")

    return pom.groupId.replace(".stable.",".canary.").replace(".unstable.", ".canary.")
}
