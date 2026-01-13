#!/bin/zsh

podman build -t=springsample:latest .

podman run -d -p 8080:8280 springsample:latest

# curl http://127.0.0.1:8080/api/v1/info
# curl http://127.0.0.1:8080/api/v1/swagger-ui.html