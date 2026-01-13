docker build -t=jeesample:latest .
docker run -d -p 8080:8080 jeesample:latest

curl http://127.0.0.1:8080/sampleProject