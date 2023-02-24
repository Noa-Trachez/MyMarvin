docker stop $(docker ps -a -q)
docker image prune -f
docker container prune -f
