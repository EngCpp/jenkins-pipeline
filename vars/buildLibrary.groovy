def call() {
   log.info 'LIBRARY FORGE'
   node {
      checkoutWithTags()
      def nextTag = prepareVersion()
      // validate()
      deploy(nextTag)
   }
}
