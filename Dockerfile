FROM maven:latest

WORKDIR /app

RUN apt-get update && apt-get install -y \
    iputils-ping \
    netcat-openbsd \
    && rm -rf /var/lib/apt/lists/*

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "module-application/target/module-application-1.0-SNAPSHOT.jar"]
