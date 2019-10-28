def call(cascades = []) {	
  log.info 'CASCADE'
	
  stage('cascade') {
    for (String cascade : cascades) {
      try {
        def breakout = cascade.tokenize('/')
        if (breakout[1]) {
	        build job: "EngCpp/${breakout[0]}/${breakout[1]}", wait: false
        } else {
	        build job: "EngCpp/${cascade}/${BRANCH_NAME}", wait: false
        }
      }
      catch (failure) {
        echo "Failed to cascade EngCpp/${cascade}/${BRANCH_NAME}"
      }
    }
  }
}
