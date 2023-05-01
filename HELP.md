# Microservices | Docker | Kubernetes


### Run MySQL
docker run -p 3306:3306 -d  --name dockerMysql --network spring -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=msvc_usuarios mysql


### Run PostgreSQL
docker run -p 5432:5432 -d  --name dockerPostgres --network spring -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -e POSTGRES_DB=msvc_cursos postgres

### Build image

docker build -t usuarios . -f ./msvc-usuarios/Dockerfile

docker build -t cursos . -f ./msvc-cursos/Dockerfile 
 ### Build network
docker network create spring

### Run containers
docker run -p 8001:8001 -d --rm --name msvc-usuarios --network spring usuarios

docker run -p 8002:8002 -d --rm --name msvc-cursos --network spring cursos