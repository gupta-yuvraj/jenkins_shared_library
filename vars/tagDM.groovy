def call() {
  sh "mkdir -p /tmp/containers"
  sh "docker login -u calm -p eye2eye registry.calm.nutanix.com:5001"
  sh "cd /tmp/containers && wget http://endor.dyn.nutanix.com/GoldImages/domain_manager/docker/master/domain_manager.tar.xz"
  // while (true) {
  //     def sout = new StringBuilder(), serr = new StringBuilder()
  //     def loadCmd = "docker load -i /tmp/containers/domain_manager.tar.xz".execute()
  //     loadCmd.consumeProcessOutput(sout, serr)
  //     loadCmd.waitFor()
  //     exitCode = loadCmd.exitValue()
  //     if (exitCode == 0) {
  //       println "dm loaded successfully"
  //       break
  //     }
  //     else {
  //       println "dm loading failed, retrying..."
  //     }
  // }
  while (true) {
    sh "docker load -i /tmp/containers/domain_manager.tar.xz"
    def exitCode = sh(script: "echo \$?", returnStdout: true).trim()
    println "exitCode -> ${exitCode}" 
    if (exitCode == '0') {
      println "dm loading successful"
      break
    }
    else {
      println "dm loading failed, retrying.."
    }
  }
  sh "docker rmi domain_manager"
  sh "rm /tmp/containers/domain_manager.tar.xz"
//   sh "docker tag domain_manager:latest registry.calm.nutanix.com:5001/domain_manager/nightly:latest "
//   sh "docker push registry.calm.nutanix.com:5001/domain_manager/nightly"
}