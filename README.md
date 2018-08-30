# Spring Cloud - Zuul
---
# Übersicht
- Zuul ist von Netflix entwickelt worden
- API Gateway/Routing Service/Proxy
- Mit Java erweiterbarer HTTP-Proxy
- kein L4-Loadbalancer wie HAProxy

# TODO Diagramm Netzwerk

# Versionswirrwarr
- Spring Cloud (Spring Boot 2.0.4) nutzt Zuul 1.3
- Mittlerweile Zuul 2.1 verfügbar (non-blocking, HTTP/2, Mutual TLS usw.); 
- Spring Cloud Zuul wird nicht auf 2.x upgraden (https://www.youtube.com/watch?time_continue=1037&v=9wocKqF15B8)

# Alternativen
- Spring Cloud Gateway (Java)
- linkerd (Scala, Java)
- envoy (C++)
- NGINX (JavaScript, Lua)

# Andere Spring Cloud-Integrationen

- Eureka
- Ribbon
- Configserver
- Zipkin