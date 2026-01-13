# 💻 Virtualizacija in delo z zabojniki s pomočjo platforme Docker


### 🎯 **Cilji delavnice**

V tej delavnici bomo spoznali koncept virtualizacije in zabojnikov ter praktično uporabili platformo **Docker** za razvoj, deljenje in izvajanje aplikacij v zabojniških okoljih. Udeleženci bodo skozi teoretične razlage in praktične primere spoznali:

- vlogo zabojnikov v širšem kontekstu **virtualizacije** razvojno/izvajalnih okolij,
- način delovanja, ukaze in uporabo platforme **Docker**,
- postopke deljenja in uporabe **zabojniških slik**,
- problematiko **orkestriranja** in **razširjanja** zabojnikov ter ustrezne rešitve,
- dobre prakse razvoja in uporabe zabojnikov.


### 📘 **Vsebina delavnice**


#### 🌐 1. Virtualizacija razvojno-izvajalnih okolij
- Poslovni vidiki virtualizacije
- Klasična delitev storitev: IaaS, PaaS, SaaS, FaaS
- Tehnične prednosti in omejitve virtualizacije
- Domorodno oblačne aplikacije – smernice fundacije CNCF
- Praktičen primer uporabe virtualizacije v sklopu razvoja in dostave informacijskih rešitev

#### 🗂️ 2. Zabojniki
- Koncept pakiranja izvajalnih okolij in aplikacij v zabojnike
- Tehnične osnove zabojnikov na primeru platforme Docker
- Osnovni koncepti: slike, podatkovne shrambe, zabojniki, virtualizirano omrežje

#### 🧩 3. Platforma Docker
- Lokalna vzpostavitev in uporaba okolja Docker
- Gradnja in zagon lastnih OCI slik
- Pristop večstopenjske gradnje slik
- Deljenje slik v tržnicah
- Varnostno skeniranje slik pred uporabo
- Izzivi orkestracije zabojnikov

#### 🚀 4. Uporaba zabojnikov v oblaku
- Zagon slik v oblaku
- Dobre prakse uporabe zabojnikov
- Upravljanje t.i. skrivnosti (občutljivih podatkov) v okolju Docker
- Platforme za skaliranje zabojnikov: Docker Swarm, Kubernetes



### 🧩 **Primeri uporabe**

V mapi [`primeri/`](primeri/README.md) so na voljo praktični primeri in skripte, ki prikazujejo uporabo osnovnih in naprednih ukazov.

### 🧮 **Naloge za udeležence**

📘 [**naloge/**](naloge/README.md) – vsebuje praktične naloge in izzive za samostojno delo udeležencev.

## 🧰 Priprava pred delavnico
Pred delavnico naj udeleženci poskrbijo za:

1. Namestitev **Docker Desktop** (ali Docker Engine) na svoj računalnik.
2. Osnovno poznavanje terminala (Linux/macOS) ali ukazne vrstice (Windows).
3. Pripravljen primer preproste aplikacije (opcijsko) za praktične vaje.

## 🌐 Koristni viri
- [Uradna dokumentacija Docker](https://docs.docker.com/)
- [CNCF Cloud Native Computing Foundation](https://www.cncf.io/)
- [Docker Hub](https://hub.docker.com/)
- [Kubernetes Documentation](https://kubernetes.io/docs/)
