# Keycloak docker demo

Based on this [absolutely amazing post](https://medium.com/@ravthiru/rest-service-protected-using-keycloak-authorization-services-a6ad2d8ecb9f)

Moreover, [check how smoothly Keycloak is fitting on ISTIO](https://www.keycloak.org/2018/02/keycloak-and-istio.html)

## Setup

1. goto [Play with docker](https://labs.play-with-docker.com/)
2. Run keycloak on docker, browse to keycloak console and import this [file](./scripts/realm-University.json)

```
git clone https://github.com/agilesolutions/keycloak.git
#docker run -d --name keycloak -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -e KEYCLOAK_IMPORT=/tmp/realm-University.json -v /root/keycloak/scripts:/tmp/realm-University.json jboss/keycloak
docker network create cloud
docker run -d --name keycloak --net cloud -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak
WAIT AND LET KEYCLOAK BOOT UP AND CREATE ITS IN MEM DB SCHEMA
docker logs -f keycloak
docker exec -ti keycloak /bin/bash
cd keycloak
docker build -t demo .
docker run -d --name demo  --net cloud 	-p 8081:8090 demo
docker run -ti --name demo demo /bin/sh

```
[Read docker run instructions!(https://hub.docker.com/r/jboss/keycloak/)

## Keycloak and Springboot

Keycloak is based on a set of administrative UIs and a RESTful API. Keycloak supports fine-grained authorization policies and is able to combine different access control mechanisms such as:

Attribute-based access control (ABAC)

Role-based access control (RBAC)

User-based access control (UBAC)

Context-based access control (CBAC)

* [Securing Spring Microservices with Keycloak part 1](https://blog.jdriven.com/2018/10/securing-spring-microservices-with-keycloak-part-1/)
* [Securing Spring Microservices with Keycloak part 2](https://blog.jdriven.com/2018/10/securing-spring-microservices-with-keycloak-part-2/)
* [REST Service Protected Using Keycloak Authorization Services](https://medium.com/@ravthiru/rest-service-protected-using-keycloak-authorization-services-a6ad2d8ecb9f)
* [The sources from above post](https://github.com/ravthiru/keycloak-recepies)
* [Keycloak github quickstarts](https://github.com/keycloak/keycloak-quickstarts)
* [About policies and authorization](https://www.keycloak.org/docs/6.0/authorization_services/#_overview)
* [The Benefits of Migrating from ADFS to Keycloak](The Benefits of Migrating from ADFS to Okta)

## some other valuable resources

* [about](https://www.keycloak.org/about.html)
* [quick-guide-using-keycloak-identity-access-management](https://www.comakeit.com/blog/quick-guide-using-keycloak-identity-access-management/)
* [wikipedia](https://en.wikipedia.org/wiki/Keycloak)
* [deep dive GREAT INTRO](https://www.thomasvitale.com/introducing-keycloak-identity-access-management/)
* [keycloak and istio](https://www.keycloak.org/2018/02/keycloak-and-istio.html)
* [stack overflow about istio and keycloak](https://stackoverflow.com/questions/55159887/istio-oauth2-with-keycloak)
