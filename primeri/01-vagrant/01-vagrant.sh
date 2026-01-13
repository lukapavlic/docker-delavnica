#!/bin/zsh

vagrant init bento/ubuntu-22.04
vagrant up --provider=virtualbox
vagrant ssh
vagrant halt
