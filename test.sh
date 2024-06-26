docker run --name my_marvin --rm --detach \
  --network jenkins --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client --env DOCKER_TLS_VERIFY=1 \
  --publish 8080:8080 --publish 50000:50000 \
  --volume jenkins-data:/var/jenkins_home \
  --volume jenkins-docker-certs:/certs/client:ro \
  --mount type=bind,source=$PWD/my_marvin.yml,target=/var/jenkins_home/jenkins.yaml \
  --mount type=bind,source=$PWD/job_dsl.groovy,target=/var/jenkins_home/job_dsl.groovy \
  jenkins/jenkins:lts
