
#Redis via Docker

Se você já tem o Docker instalado, basta rodar o seguinte comando no terminal:

	docker run --name redis -p 6379:6379 -d redis

Explicando o que cada parte do comando faz:

	--name redis: Nomeia o container como "redis".

	-p 6379:6379: Mapeia a porta 6379 do Redis para a porta 6379 do seu sistema.

	-d: Executa o container em segundo plano (modo "detached").

	redis: Usa a imagem oficial do Redis no Docker Hub.

Verificando se o Redis está funcionando

	docker ps
	
	docker exec -it redis redis-cli
	
	127.0.0.1:6379> ping
	PONG

No arquivo application.properties do seu projeto Spring Boot, configure a conexão com o Redis:

	spring.redis.host=localhost
	spring.redis.port=6379
	spring.redis.password= # Deixe vazio, pois não há senha por padrão

#Testando 1 via Postman ou Browser

Este procedimento aciona o module-application

	POST localhost:8080/redis/set?key=nome&value=João

	GET localhost:8080/redis/get?key=nome

	DELETE localhost:8080/redis/delete?key=nome

#Parando o Redis no Docker

	docker stop redis

	docker rm redis

#Testando 2 via Postman ou Browser

Apos Teste 1 via module-application, vamos fazer o Teste 2 que aciona o module-service e module-web

	GET localhost:8080/api/products/redis/get?key=nome

	POST localhost:8080/api/products/redis/set?key=nome&value=Maria

Nosso exemplo sobrescreve o valor e estamos alternando "nome" entre "Joao" e "Maria"
