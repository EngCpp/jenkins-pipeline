def call() {   
   agent none
   log.info 'LIBRARY FORGE'
   def nextTag = prepareVersion()
   // validate()
   deploy(nextTag)
}
