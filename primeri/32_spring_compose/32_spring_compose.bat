docker compose build
docker compose up -d

curl http://127.0.0.1:8280/api/v1/info

# curl http://127.0.0.1:8280/api/v1/swagger-ui.html