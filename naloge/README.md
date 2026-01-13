# 🧮 Docker — Praktične naloge

Ta mapa vsebuje **praktične naloge**, namenjene utrjevanju znanja o **zabojnikih** in uporabi platforme **Docker**.  
Vsaka naloga vas vodi korak bližje k obvladovanju osnovnih in naprednih konceptov. 🚀

---

## 📋 Kazalo nalog

1. [Zagon MongoDB](#1-naloga--zagon-mongodb-zabojnika)
2. [Zagon MySQL z osnovnimi parametri](#2-naloga--zagon-mysql-z-osnovnimi-parametri)
3. [MySQL: porti, volume in detached način](#3-naloga--mysql-porti-volume-in-detached-način)
4. [Docker Desktop in Portainer](#4-naloga--docker-desktop-in-portainer)
5. [Java Hello World v Dockerju](#5-naloga--java-hello-world-v-dockerju)
6. [Spring Boot JAR v Dockerju](#6-naloga--spring-boot-jar-v-dockerju)
7. [Spring Boot + PostgreSQL (Docker Compose)](#7-naloga--spring-boot--postgresql-docker-compose)
8. [Node.js multi-stage build](#8-naloga--nodejs-multi-stage-build)
9. [Varnostni pregled slike](#9-naloga--varnostni-pregled-slike)
10. [Objava slike na Docker Hub](#10-naloga--objava-slike-na-docker-hub)

---

## 1. Naloga — Zagon MongoDB

**Cilj:**  
Spoznati osnovne Docker ukaze za delo s slikami in zabojniki.

### Navodila
1. Zaženi MongoDB zabojnik z ukazom `docker run mongo`.
2. Opazuj, kaj se zgodi ob prvem zagonu (pull slike).
3. V drugem terminalu preveri, ali zabojnik teče.
4. Preglej loge zabojnika.
5. Zabojnik ustavi in ponovno zaženi.
6. Izpiši seznam slik in preveri njihove plasti.
7. Vstopi v zabojnik z interaktivno lupino.

### Uporabni ukazi
- `docker run mongo`
- `docker ps`, `docker ps -a`
- `docker images`
- `docker logs <container>`
- `docker stop <container>`
- `docker start <container>`
- `docker history mongo`
- `docker exec -it <container> bash`

---

## 2. Naloga — Zagon MySQL z osnovnimi parametri

**Cilj:**  
Razumeti uporabo parametrov, okoljskih spremenljivk in verzij slik.

### Navodila
1. Zaženi MySQL zabojnik z nastavitvijo root gesla.
2. Opazuj, kaj se zgodi ob prvem zagonu.
3. Preveri loge in ugotovi, ali se baza pravilno inicializira.
4. Razmisli, zakaj je pomembno navajanje verzije slike.

### Uporabni ukazi
- `docker run -e MYSQL_ROOT_PASSWORD=root mysql:9.5.0`
- `docker logs <container>`
- `docker images`

---

## 3. Naloga — MySQL: porti, volume in detached način

**Cilj:**  
Razumeti delo v ozadju, mapiranje portov in trajnost podatkov.

### Navodila
1. Zaženi MySQL zabojnik v detached načinu.
2. Mapiraj port 3306 na lokalni računalnik.
3. Nastavi privzeto bazo.
4. Dodaj Docker volume za podatke baze.
5. Na Docker Hub preveri dokumentacijo za MySQL sliko.
6. Zabojnik ustavi, odstrani in ponovno zaženi ter preveri podatke.

### Uporabni ukazi
- `docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=baza mysql:9.5.0`
- `docker volume ls`
- `docker inspect <container>`
- Docker Hub dokumentacija (MySQL)

---

## 4. Naloga — Docker Desktop in Portainer

**Cilj:**  
Spoznati grafične vmesnike za upravljanje Dockerja.

### Navodila
1. Odpri Docker Desktop.
2. Preglej:
   - zabojnike
   - slike
   - loge
   - volume
3. Zaženi Portainer iz uradne Docker Hub slike.
4. Dostopi do Portainer web vmesnika.
5. Preglej stanje zabojnikov in loge.
6. Poskusi se povezati na MySQL bazo preko orodij v zabojniku.

### Uporabni ukazi
- `docker volume create portainer_data`
- `docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:2.20.2`

---

## 5. Naloga — Java Hello World v Dockerju

**Cilj:**  
Ustvariti prvo lastno Docker sliko za Java aplikacijo.

### Navodila
1. Prejmeš datoteko `Zdravo.java`.
2. Napiši `Dockerfile`, ki:
   - uporabi ustrezno Java sliko
   - zažene program
3. Zgradi Docker sliko.
4. Zaženi zabojnik in preveri izpis.

### Uporabni ukazi
- `docker build -t zdravo-java .`
- `docker run zdravo-java`

---

## 6. Naloga — Spring Boot JAR v Dockerju

**Cilj:**  
Zapakirati obstoječo Java aplikacijo v Docker zabojnik.

### Navodila
1. Prejmeš datoteko `backend.jar`.
2. Napiši `Dockerfile`, ki:
   - kopira JAR v sliko
   - zažene aplikacijo
3. Zgradi sliko.
4. Zaženi zabojnik in preveri delovanje aplikacije.

### Uporabni ukazi
- `docker build -t backend-app .`
- `docker run -p 8280:8280 backend-app`

---

## 7. Naloga — Spring Boot + PostgreSQL (Docker Compose)

**Cilj:**  
Vzpostaviti več-zabojni sistem z Docker Compose.

### Navodila
1. Uporabi `backend.jar`.
2. Pripravi `docker-compose.yml`, ki vključuje:
   - Spring Boot aplikacijo
   - PostgreSQL bazo
3. Nastavi okoljske spremenljivke za povezavo na bazo.
4. Zaženi celoten stack z enim ukazom.
5. Preveri, ali se aplikacija poveže na bazo.

### Uporabni ukazi
- `docker compose up`
- `docker compose ps`
- `docker compose logs`

---

## 8. Naloga — Node.js multi-stage build

**Cilj:**  
Spoznati večstopenjsko grajenje Docker slik.

### Navodila
1. Prejmeš `server.js` in `package.json`.
2. Napiši **multi-stage Dockerfile**:
   - build stage (namestitev odvisnosti)
   - runtime stage
3. Zgradi sliko.
4. Zaženi zabojnik in preveri HTTP odziv.

### Uporabni ukazi
- `docker build -t node-multistage .`
- `docker run -p 3000:3000 node-multistage`

---

## 9. Naloga — Varnostni pregled slike

**Cilj:**  
Spoznati osnovne varnostne preglede Docker slik.

### Navodila
1. Vzemi sliko iz prejšnje naloge.
2. Izvedi varnostni pregled.
3. Preglej poročilo in identificiraj ranljivosti.
4. Razmisli, od kod izvirajo ranljivosti.

### Uporabni ukazi
- `docker scout quickview <image>`

---

## 10. Naloga — Objava slike na Docker Hub

**Cilj:**  
Deliti lastno Docker sliko z drugimi.

### Navodila
1. Prijavi se v Docker Hub.
2. Označi sliko z ustreznim imenom (`username/ime-slike:tag`).
3. Objavi sliko.
4. Preveri, ali jo lahko nekdo drug prenese in zažene.

### Uporabni ukazi
- `docker login`
- `docker tag node-multistage username/node-multistage:1.0`
- `docker push username/node-multistage:1.0`
- `docker pull username/node-multistage:1.0`

---


