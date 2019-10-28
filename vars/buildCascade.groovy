def call(cascades = []) {
  stage('cascade') {
    for (String cascade : cascades) {
      try {
        def breakout = cascade.tokenize('/')
        if (breakout[1]) {
	        build job: "${breakout[0]}/${breakout[1]}", wait: false
        } else {
	        build job: "${cascade}/${BRANCH_NAME}", wait: false
        }
      }
      catch (failure) {
        echo "Failed to cascade ${cascade}/${BRANCH_NAME}"
      }
    }
  }
}
