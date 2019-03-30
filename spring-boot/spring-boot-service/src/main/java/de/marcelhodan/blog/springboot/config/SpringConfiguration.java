package de.marcelhodan.blog.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.marcelhodan.blog.springboot.ScanPackage;
import de.marcelhodan.blog.springboot.dataaccess.DataAccessScanPackage;
import de.marcelhodan.blog.springboot.dataaccess.application.model.CarE;
import de.marcelhodan.blog.springboot.dataaccess.repos.CarRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = DataAccessScanPackage.class)
@EntityScan(basePackageClasses = DataAccessScanPackage.class)
@ComponentScan(basePackageClasses = ScanPackage.class)
@Import({ SwaggerConfiguration.class, EntityMappingConfiguration.class })
public class SpringConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringConfiguration.class);

    @Bean
    public ObjectMapper objectMapper() {
	return new ObjectMapper();
    }

    @Bean
    public CommandLineRunner demo(CarRepository repository) {
	return (args) -> {
	    // save a couple of Cars
	    repository.save(new CarE("A1", "Audi"));
	    repository.save(new CarE("i8", "BWM"));
	    repository.save(new CarE("Viper", "Dodge"));
	    repository.save(new CarE("Focus", "Ford"));
	    repository.save(new CarE("Swift", "Suzuki"));

	    // fetch all Cars
	    LOGGER.info("Cars found with findAll():");
	    LOGGER.info("-------------------------------");
	    LOGGER.info("");

	    // fetch an individual Car by ID
	    repository.findById(1L).ifPresent(car -> {
		LOGGER.info("Car found with findById(1L):");
		LOGGER.info("--------------------------------");
		LOGGER.info(car.toString());
		LOGGER.info("");
	    });

	    // fetch Cars by last name
	    LOGGER.info("Car found with findByManufacturer('Dodge'):");
	    LOGGER.info("--------------------------------------------");
	    repository.findByManufacturer("Dodge").forEach(doge -> {
		LOGGER.info(doge.toString());
	    });
	    LOGGER.info("");
	};
    }
}