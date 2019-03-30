package de.marcelhodan.blog.springboot.dataaccess.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.marcelhodan.blog.springboot.dataaccess.application.model.CarE;

@Repository
public interface CarRepository extends CrudRepository<CarE, Long> {

    List<CarE> findByModel(String model);

    List<CarE> findByManufacturer(String manufacturer);
}