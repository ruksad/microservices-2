# microservices-2

#api gateway 
1. Eureka client
2. Services routing
3. default routing
4. you can open the h2 console using http://host:port/h2-console


# car-service
1. h2 in-memory database
2. Eureka client


# employee-service
shows example of spring-data-jpa
1. One-to-many
2. Many-to-many
3. Embeddable
4. pagination
5. Fly-way
6. Eureka client
7. Open feign client for car service    feign client declarative rest client it takes service name from discovery client and path to the api mapping, it does client side load balancing
8. Resilience4j circuit breaker


#spring cloud config server
It is client server architecture where config server will read props from git or mysql or some db and 