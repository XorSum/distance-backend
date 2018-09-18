kill -9 $(lsof -ti tcp:8086)
setsid ./mvnw spring-boot:run
