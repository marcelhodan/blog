package de.marcelhodan.blog.springboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;

import de.marcelhodan.blog.springboot.config.SpringConfiguration;

public class SpringBootApplication {

    public static void main(String[] args) throws IOException {
	SpringApplication.run(SpringConfiguration.class, args);
    }

}