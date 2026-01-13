#!/bin/zsh

# javac Server.java
docker build -t=javaserverdemo .
tag javaserverdemo iideveloper21/javaserverdemo:latest
docker push iideveloper21/javaserverdemo:latest
