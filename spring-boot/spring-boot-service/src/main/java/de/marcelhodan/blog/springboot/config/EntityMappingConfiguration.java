package de.marcelhodan.blog.springboot.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.marcelhodan.blog.springboot.dataaccess.mapper.CarMapper;

@Configuration
public class EntityMappingConfiguration {
    @Bean
    public CarMapper carMapper() {
	return Mappers.getMapper(CarMapper.class);
    }
}
