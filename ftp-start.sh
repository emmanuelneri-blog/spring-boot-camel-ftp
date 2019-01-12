#!/usr/bin/env bash

docker run -itd \
    --name ftp-server \
    -e FTP_USER_NAME=usuario \
    -e FTP_USER_PASS=123 \
    -e FTP_USER_HOME=/home/usuario \
    -e "PUBLICHOST=localhost" \
    -e TZ=America/Sao_Paulo \
    -p 21:21 \
    -p 30000-30009:30000-30009 \
    stilliard/pure-ftpd

docker exec -d ftp-server sh -c 'mkdir /home/usuario/arquivos'
docker exec -d ftp-server sh -c 'mkdir /home/usuario/arquivos/sucesso'
docker exec -d ftp-server sh -c 'mkdir /home/usuario/arquivos/erro'
docker exec -d ftp-server sh -c 'chmod -R 777 home/usuario/arquivos'

docker exec -d ftp-server sh -c 'touch /home/usuario/arquivos/arquivo1.txt .'
docker exec -d ftp-server sh -c 'touch /home/usuario/arquivos/arquivo2.txt .'