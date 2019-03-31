# Spring boot with Primefaces
This projects contains a template to use `spring boot` in a maven structure with separate projects for `api`, `service` and `api`.

## Get started
To start the application you can use the following CLI steps to build the project.

### Java
1. clone this `repository`<br>
`git clone https://github.com/marcelhodan/blog.git`
1. move into project folder<br>
`cd spring-boot/`
1. build project<br>
`mvn clean install`
1. move into target folder of spring-boot-service project<br>
`cd spring-boot-service/target/` 
1. run executable jar<br>
`java -jar spring-boot-service-0.0.1-SNAPSHOT.jar`


### Docker
1. clone this `repository`<br>
`git clone https://github.com/marcelhodan/blog.git`
1. move into project folder<br>
`cd spring-boot/`
1. build project<br>
`mvn clean install dockerfile:build`
1. start docker container<br>
`docker run -p 8080:8080 -t blog/spring-boot-service`


## Structure
* [API readme](spring-boot-api)
* Service<br>
The main content and actual work/configuration will be found within the Service project.<br>
*Further reading* [Service readme](spring-boot-service/README.md)
* [UI readme](spring-boot-ui)

## Libraries
This project uses these libraries/frameworks:

* H2 database
* Lombok
* Mapstruct
* Swagger
* Joinfaces
