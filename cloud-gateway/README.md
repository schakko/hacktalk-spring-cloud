# Spring Cloud Gateway

This application runs a Spring Cloud Gateway 2.x proxy to forward incoming HTTP requests to backend microservices (*echo-microservice*, *authentication-microservice*).

## Service discovery
For service and routing discovery, Netflix' Eureka is used. Therefore

	spring.cloud.gateway.discovery.locator.enabled=true
	
has been set to true.

To use lowercase service URLs, https://github.com/spring-cloud/spring-cloud-gateway/issues/302#issuecomment-408610418 had to be adjusted.

# Filters

- AddRequestHeaderFilter to set some HTTP headers for proxied microservices
- AddResponseHeaderFilter to calculate the delay between incoming request and sent response

# Endpoints

- http://localhost/ - overview
- http://localhost/echo - proxied to *echo-microservice:/*
- http://localhost/auth/login - proxied to *authentication-microservice:/login*
- http://localhost/auth/logout- proxied to *authentication-microservice:/logout*
