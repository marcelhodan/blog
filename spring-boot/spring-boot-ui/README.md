# UI
The UI project will provide the necessary content to add UI elements.

## Structure
Because this project only will be included as dependency to another `spring boot` project the resources for the `webapp` have to be placed in `META-INF/resources/`.

#### Example
To add for example a `index.xhtml` file to the project this would be the full path relative to the *spring-boot-ui* project root.

	src/main/resources/META-INF/resources/index.xhtml
	
See also: [index.xhtml](src/main/resources/META-INF/resources/index.xhtml)

## Spring boot integration
There is currently (31.03.2019) no integration for JSF from [spring.io](https://spring.io/). 

### Joinfaces
But gladly there is a framework called [Joinfaces](http://joinfaces.org/) which enables this missing part.

> It autoconfigures PrimeFaces, PrimeFaces Extensions, AdminFaces, BootsFaces,  ButterFaces, IceFaces, RichFaces, OmniFaces, AngularFaces, Mojarra and MyFaces libraries to run at embedded Tomcat, Jetty or Undertow servlet containers. It autoconfigures Weld and Rewrite too.

### Integration
With the following dependency the autoconfiguration and primefaces will be included into the project.

```xml
<dependency>
	<groupId>org.joinfaces</groupId>
	<artifactId>primefaces-spring-boot-starter</artifactId>
</dependency>
```