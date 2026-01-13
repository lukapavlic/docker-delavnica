# 📂 Primeri uporabe zabojnikov

V tej mapi so zbrani praktični primeri, ki spremljajo delavnico **Virtualizacija in delo z zabojniki s pomočjo platforme Docker**. Namen primerov je, da udeleženci preko konkretnih vaj utrdijo teoretično znanje in se seznanijo z osnovnimi ukazi ter praksami platforme Docker.

Vsak primer je pripravljen v dveh različicah:
- `.bat` – za okolje **Windows**
- `.sh` – za okolje **Linux/Mac**


## 🔧 Seznam primerov


| Podimenik | Opis | Glavni cilj |
|-----------|------|-------------|
| `01-vagrant` | Osnovna uporaba Vagranta za pripravo virtualnih okolij | Spoznati integracijo virtualizacije in pripravo razvojnih okolij |
| `02-vagrant-custom` | Prilagojene Vagrant konfiguracije | Učenje naprednejše konfiguracije in avtomatizacije VM |
| `03-docker-vm` | Zagon Docker okolja znotraj VM | Razumevanje uporabe Dockerja v virtualiziranem okolju |
| `03-podman-vm` | Primeri uporabe Podman kot alternative Dockerju | Spoznati alternativno platformo za zabojnike |
| `10-terraform` | Uporaba Terraform za avtomatizacijo infrastrukture | Razumevanje infrastrukture kot kode za pripravo okolij |
| `20-0_docker_minimal_run` | Minimalni primer zagona zabojnika | Spoznati osnovne ukaze `docker run` in `docker ps` |
| `20-1_docker_minimal_build` | Minimalni primer gradnje slike | Naučiti se `docker build` in osnovne Dockerfile strukture |
| `21_docker_java` | Gradnja in zagon Java aplikacije v zabojniku | Spoznati zagon JVM aplikacij v Dockerju |
| `22_docker_server` | Zagon strežniške aplikacije v zabojniku | Praktična uporaba zabojnikov za strežnike |
| `23_jee_web_sample` | Primer JEE web aplikacije | Razumevanje standardnih JEE aplikacij v zabojnikih |
| `23_spring_sample` | Primer Spring Boot aplikacije | Učenje kontejnerizacije Spring Boot aplikacij |
| `23_spring_sample-podman` | Spring Boot aplikacija z uporabo Podmana | Alternativni pristop z drugo platformo za zabojnike |
| `30_jee_mysql` | Kombinacija JEE aplikacije in MySQL | Spoznati povezovanje zabojnikov in uporabo podatkovnih baz |
| `31_jee_mysql_compose` | Uporaba Docker Compose za JEE + MySQL | Učenje orkestracije več zabojnikov z Docker Compose |
| `32_spring_compose` | Spring Boot aplikacija z Docker Compose | Orkestracija mikrostoritev Spring aplikacij |
| `32_spring_compose-podman` | Spring Boot + Compose na Podman | Alternativni način orkestracije z Podman Compose |
| `40_docker_push` | Deljenje slik na Docker Hub | Naučiti se nalagati in pridobivati slike iz registra |
| `50_security_scan` | Varnostno skeniranje slik | Spoznati dobre prakse varnostnega preverjanja slik |
| `60_multistage` | Večstopenjska gradnja Docker slik | Optimizacija velikosti in organizacije Dockerfile |
| `70_kubernetes` | Zagon aplikacij v Kubernetesu | Osnove orkestracije zabojnikov v oblaku |
| `90_spring_src` | Spring Boot aplikacija, ki se uporablja v primerih | Razumevanje celotnega procesa: gradnja, zabojnik, zagon |

