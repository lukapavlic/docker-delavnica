terraform {
  required_providers {
    virtualbox = {
      source  = "terra-farm/virtualbox"
      version = "0.2.2-alpha.1"
    }
  }
}

provider "virtualbox" {}

resource "virtualbox_vm" "linuxvm" {
  count  = 2
  name   = "linuxvm${count.index + 1}"
  image  = "/home/luka/iso/ubuntu-22.04-live-server-amd64.iso"
  cpus   = 2
  memory = "2048MiB"

  network_adapter {
    type           = "hostonly"
    host_interface = "vboxnet0"
  }
}
