def call() {
  sh "mkdir -p /tmp/containers"
  sh "docker login -u calm -p eye2eye registry.calm.nutanix.com:5001"
  sh "cd /tmp/containers && wget http://endor.dyn.nutanix.com/GoldImages/domain_manager/docker/master/domain_manager.tar.xz"
  sh "docker load -i /tmp/containers/domain_manager.tar.xz"
  sh "docker rmi domain_manager"
//   sh "docker tag domain_manager:latest registry.calm.nutanix.com:5001/domain_manager/nightly:latest "
//   sh "docker push registry.calm.nutanix.com:5001/domain_manager/nightly"
}