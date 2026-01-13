#!/bin/bash
set -e

USER=vagrant
HOME_DIR=/home/$USER

echo "==> Posodabljam seznam paketov"
apt-get update -y

echo "==> Nameščam osnovne odvisnosti"
apt-get install -y \
    ca-certificates \
    curl \
    gnupg \
    lsb-release \
    software-properties-common \
    python3-pip \
    uidmap \
    slirp4netns \
    fuse-overlayfs \
    git

echo "==> Nameščam Podman"
apt-get install -y podman

echo "==> Nastavitev rootless Podman za uporabnika $USER"

# Subuid/subgid
if ! grep -q "^$USER:" /etc/subuid; then
    echo "$USER:100000:65536" >> /etc/subuid
fi
if ! grep -q "^$USER:" /etc/subgid; then
    echo "$USER:100000:65536" >> /etc/subgid
fi

# Omogočimo linger, da se podman socket lahko uporablja brez prijave
loginctl enable-linger $USER || true

echo "==> Nastavitev direktorijev"
sudo -u $USER mkdir -p $HOME_DIR/.local/share/containers/storage
sudo -u $USER mkdir -p $HOME_DIR/.local/share/containers/cache
sudo -u $USER mkdir -p $HOME_DIR/.config/containers

sudo -u $USER tee $HOME_DIR/.config/containers/registries.conf > /dev/null <<EOF
[registries.search]
registries = ['docker.io']
EOF

echo "==> Nameščam Podman Compose"
pip3 install --upgrade podman-compose

echo "==> Preverjam namestitev"
podman --version
podman-compose --version

echo "==> Konfiguracija Podman socket bo aktivna ob naslednji prijavi uporabnika $USER"
echo "    Za testiranje lahko po SSH izvedete:"
echo "    systemctl --user start podman.socket"
echo "    podman info"

echo "==> Podman in Podman Compose uspešno nameščena"
