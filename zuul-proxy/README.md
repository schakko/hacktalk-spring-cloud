# Zuul proxy

This application runs a Netflix Zuul 1.x proxy to forward incoming HTTP requests to backend microservices (*echo-microservice*, *authentication-microservice*).

# Filters

- AddRequestHeaderFilter to set some HTTP headers for proxied microservices
- AddResponseHeaderFilter to calculate the delay between incoming request and sent response

# Endpoints

- http://localhost/ - overview
- http://localhost/echo - proxied to *echo-microservice:/*
- http://localhost/auth/login - proxied to *authentication-microservice:/login*
- http://localhost/auth/logout- proxied to *authentication-microservice:/logout*
