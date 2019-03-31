# Service
The main content and actual work/configuration will be found within the Service project.

## Structure
#### Packages
For this project only three packages are used to structure the project files:
1. config<br>
(see [Configuration](#configuration))
1. dataaccess<br>
-> This package contains all *JPA* related implementations
    * application.model<br>
    -> package for `JPA` entities used within the application
    * mapper<br>
    -> `mapstruct` configuration for api-model to jpa-model mapping
    * repos<br>
    -> contains the spring `CrudRepositoriy` to access the jpa-models 
1. rest<br>
-> This package contains all `RestController` which provide the desired services.

#### Configuration
The configuration is placed into the package [config](src/main/java/de/marcelhodan/blog/springboot/config). It contains the main confiration file **SpringConfiguration** and additional files which will be imported separately.

Config files:
* [SpringConfiguration](src/main/java/de/marcelhodan/blog/springboot/config/SpringConfiguration.java)<br>
entry point for every configuration related to this application
* [SwaggerConfiguration](src/main/java/de/marcelhodan/blog/springboot/config/SwaggerConfiguration.java)<br>
configuration for `swagger` integration
* [EntityMappingConfiguration](src/main/java/de/marcelhodan/blog/springboot/config/EntityMappingConfiguration.java)<br>
provides `mapstruct` mapper for each mapping as `spring bean`