#!/bin/bash

# Paramos y borramos la versión anterior del portal, si existe
sudo docker stop sisinf-database
sudo docker rm sisinf-database

cd postgres
unzip main.zip

sudo docker build -t sisinf/postgresql:latest .

sudo docker run --name sisinf-database -e ALLOW_EMPTY_PASSWORD=yes -p 5432:5432 -d sisinf/postgresql:latest


cd ..

# Paramos y borramos la versión anterior del portal, si existe
sudo docker stop sisinf-tomcat
sudo docker rm sisinf-tomcat

cd tomcat
sudo docker build -t sisinf/tomcat:latest .

sudo docker run -d --name sisinf-tomcat \
  --link sisinf-database \
  -p 8080:8080 \
  sisinf/tomcat:latest
