#!/bin/zsh

docker compose build
docker compose up -d

curl http://127.0.0.1:8080/OsebeDemo/
curl http://127.0.0.1:8080/OsebeDemo/OsebeWS?wsdl
curl http://127.0.0.1:8080/OsebeDemo/rest/osebe