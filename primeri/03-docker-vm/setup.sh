#!/bin/bash
# inicializacija VM z Dockerjem

set -e

echo "=== Začetek inicializacije VM ==="

# 1. Posodobitev sistema
echo "Posodabljam sistem..."
sudo apt-get update -y
sudo apt-get upgrade -y

# 2. Namestitev potrebnih paketov
for pkg in apt-transport-https ca-certificates curl gnupg lsb-release; do
    if ! dpkg -s $pkg >/dev/null 2>&1; then
        echo "Namestim paket $pkg..."
        sudo apt-get install -y $pkg
    else
        echo "Paket $pkg je že nameščen."
    fi
done

# 3. Namestitev Dockerja, če še ni nameščen
if ! command -v docker >/dev/null 2>&1; then
    echo "Dodajam Docker repozitorij..."
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
    echo \
      "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] \
      https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" \
      | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

    echo "Posodabljam paketni seznam in nameščam Docker..."
    sudo apt-get update -y
    sudo apt-get install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

    echo "Omogočam in zaženi Docker service..."
    sudo systemctl enable docker
    sudo systemctl start docker
else
    echo "Docker je že nameščen."
fi

# 4. Dodaj uporabnika v docker skupino, če še ni
if groups $USER | grep &>/dev/null "\bdocker\b"; then
    echo "Uporabnik $USER je že v docker skupini."
else
    echo "Dodajam uporabnika $USER v docker skupino..."
    sudo usermod -aG docker $USER
    echo "Po koncu inicializacije se odjavi in ponovno prijavi, da bo sprememba veljala."
fi

# 4. Dodaj uporabnika v docker skupino, če še ni
if groups vagrant | grep &>/dev/null "\bdocker\b"; then
    echo "Uporabnik vagrant je že v docker skupini."
else
    echo "Dodajam uporabnika vagrant v docker skupino..."
    sudo usermod -aG docker vagrant
    echo "Po koncu inicializacije se odjavi in ponovno prijavi, da bo sprememba veljala."
fi

# 5. Preverjanje namestitve
echo "Docker verzija:"
docker --version
echo "Docker Compose verzija:"
docker compose version

echo "=== Inicializacija zaključena ==="
