#!/bin/zsh

# javac Test.java
docker build -t=minimaljavademo .
docker run minimaljavademo