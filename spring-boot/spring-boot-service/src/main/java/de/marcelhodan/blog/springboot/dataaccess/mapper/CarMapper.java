package de.marcelhodan.blog.springboot.dataaccess.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import de.marcelhodan.blog.springboot.api.model.Car;
import de.marcelhodan.blog.springboot.dataaccess.application.model.CarE;

@Mapper
public interface CarMapper {

    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "model", source = "model")
    Car carEntityToCar(CarE car);

    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "id", ignore = true)
    CarE carToCarEntity(Car car);
}