#!/bin/zsh

# gcc prog.c --static -o prog_arm64
docker build -t=minimaldemo .
docker run minimaldemo