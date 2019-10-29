def call() {
   log.info 'LIBRARY FORGE'
   node {
      def nextTag = prepareVersion()
      // validate()
      deploy(nextTag)
   }
}
