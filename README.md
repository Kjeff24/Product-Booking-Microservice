# Product Booking Microservice
A simple microservice with keycloak as authorization and authentication server.

## USAGE
- Command to start RabbitMQ in docker:
```
docker run --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management
```

- Command to start keycloak in docker:
  - Replace admin and admin_password with your credentials.
```
docker run --name keycloak -p 8080:8080 -e KEYCLOAK_ADMIN=<admin> -e KEYCLOAK_ADMIN_PASSWORD=<admin_password> quay.io/keycloak/keycloak:24.0.2 start-dev
```
  - After keycloak is running create a realm `demo`
![image](https://github.com/Kjeff24/Product-Booking-Microservice/assets/91270318/b241a660-71c4-41e8-9897-7370e226f9ad)
  - Create a client `spring-with-test-scope`, Valid redirect URIs `http://localhost:8765/*`, Web origins `http://localhost:8765` and ensure you have client authentication on
![image](https://github.com/Kjeff24/Product-Booking-Microservice/assets/91270318/70059f22-aa06-4b40-9944-3b974177ce38)
![image](https://github.com/Kjeff24/Product-Booking-Microservice/assets/91270318/48019043-fdea-4297-888f-e4a51b19c5ae)
  - Ensure you replace client-secret in `config-server/src/main/resources/configs/gateway.yml` with the client secret from keycloak
![image](https://github.com/Kjeff24/Product-Booking-Microservice/assets/91270318/7d1f3f80-d192-4745-bafc-a6f3ea62ff7e)
  - Create a user for authentication and authorization into the keycloak server. Ensure you enable email verified
![image](https://github.com/Kjeff24/Product-Booking-Microservice/assets/91270318/c3501b7c-3f82-4689-9ff5-c2fb0e9a464a)
  - Access your configuration endpoints at `http://localhost:8080/realms/demo/.well-known/openid-configuration`
For further information on creating realms and client checkout [Keycloak instructions](https://www.keycloak.org/getting-started/getting-started-docker)


- Ensure you load all maven files and run the application in the following order
  - config server
  - discovery server
  - gateway
  - product service
  - booking service

## TECHNOLOGIES

### Mongodb Database
Responsible for storing data

### Eureka Discovery
Service discovery server responsible for registering and locating microservices within the system.

### Config Server
Centralized configuration server responsible for storing and serving configuration properties for microservices.

### API Gateway
Acts as a single entry point for client applications to communicate with the backend microservices. It provides routing, and load balancing.

### Keycloak
Responsible for user authentication and authorization using OAuth2. (auth-server)

### Resource Server
Protect resources using Bearer Token authentication using JWT.

### Product Service
Responsible for creating product

### Booking Service
Responsible for making bookings
