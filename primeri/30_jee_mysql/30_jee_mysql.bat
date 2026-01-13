docker run -d -p 3306:3306 -v mysql_data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root mysql:8.0.27

# docker exec -it 4d bash
# docker inspect 86 | grep "IPAddress"

docker build -t=jeesample2:latest .

docker run -d -p 8080:8080 jeesample2:latest

curl http://127.0.0.1:8080/OsebeDemo/
curl http://127.0.0.1:8080/OsebeDemo/OsebeWS?wsdl
curl http://127.0.0.1:8080/OsebeDemo/rest/osebe