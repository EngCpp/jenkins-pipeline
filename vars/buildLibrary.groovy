def call() {
   log.info 'LIBRARY FORGE'
   def nextTag = prepareVersion()
   // validate()
   deploy(nextTag)
}
