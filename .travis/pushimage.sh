
#!/bin/bash
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
export TAG=`if [ "$TRAVIS_BRANCH" == "master" ]; then echo "latest"; else echo $TRAVIS_BRANCH ; fi`
export IMAGE_NAME=stmalike/$SERVICE_DIR
docker build -f Dockerfile -t $IMAGE_NAME:$TAG .
docker tag $IMAGE_NAME:$COMMIT $IMAGE_NAME:$TAG
docker tag $IMAGE_NAME:$COMMIT $IMAGE_NAME:travis-$TRAVIS_BUILD_NUMBER
docker push $IMAGE_NAME
  