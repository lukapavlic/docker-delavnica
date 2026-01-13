#!/bin/zsh

docker build -t=springsample:latest .

docker run -d -p 8080:8280 springsample:latest

sleep 2

curl http://127.0.0.1:8080/api/v1/info

# curl http://127.0.0.1:8080/api/v1/swagger-ui.html