def call(cascades = []) {	
  log.info 'CASCADE'
	
  stage('cascade') {
	  
    for (String cascade : cascades) {
      try {
        def breakout = cascade.tokenize('/')
        if (breakout[1]) {
	    build job: "${breakout[0]}", wait: false
        } else {
	    build job: "${cascade}", wait: false
        }
      } catch (failure) {
	log.info "${failure}"
        log.info "Failed to cascade ${cascade}/${BRANCH_NAME}"
      }
    }
	  
  }
}
