#!/bin/zsh

docker build -f Dockerfile-SS -t=springsample:singlestage .
docker build -f Dockerfile-MS -t=springsample:multistage .

