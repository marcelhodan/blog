package de.marcelhodan.blog.springboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.marcelhodan.blog.springboot.config.SpringConfiguration;

@SpringBootApplication
public class SpringBootApplicationMain {

    public static void main(String[] args) throws IOException {
	SpringApplication.run(SpringConfiguration.class, args);
    }

}