# Eureka server

This application starts Netflix' Eureka Server on port 8200. Microservices like *echo-microservice* and *authentication-microservice* do register their instance during the microservice's startup.

# Endpoints

- http://localhost:8200/ - showing the registered Eureka clients
