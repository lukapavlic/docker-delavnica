#!/bin/zsh

podman-compose build
podman-compose up -d

curl http://127.0.0.1:8080/api/v1/info

# curl http://127.0.0.1:8080/api/v1/swagger-ui.html