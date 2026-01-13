#!/bin/zsh

# javac Server.java
docker build -t=javaserverdemo .
# docker run javaserverdemo
docker run -p 8080:8080 javaserverdemo