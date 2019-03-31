package de.marcelhodan.blog.springboot.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.marcelhodan.blog.springboot.api.model.Car;
import de.marcelhodan.blog.springboot.api.service.CarServiceI;
import de.marcelhodan.blog.springboot.dataaccess.application.model.CarE;
import de.marcelhodan.blog.springboot.dataaccess.mapper.CarMapper;
import de.marcelhodan.blog.springboot.dataaccess.repos.CarRepository;

@RestController
@RequestMapping(CarController.ROOT_CONTEXT)
public class CarController extends BaseController implements CarServiceI {
    static final String ROOT_CONTEXT = "/cars";
    private static final String CONTEXT_ALL = "/all";
    private static final String CONTEXT_ADD = "/add";
    private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);
    @Autowired
    private CarRepository repository;
    @Autowired
    private CarMapper carMapper;

    public CarController() {
	super(ROOT_CONTEXT);
    }

    /* (non-Javadoc)
     * @see de.marcelhodan.blog.springboot.rest.CarServiceI#listAllCars()
     */
    @Override
    @GetMapping(value = CONTEXT_ALL, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Car> listAllCars() {
	LOGGER.info("list all cars via {}", fullContextPath(CONTEXT_ALL));
	List<Car> cars = new ArrayList<>();
	for (CarE car : repository.findAll()) {
	    LOGGER.info(car.toString());
	    cars.add(carMapper.carEntityToCar(car));
	}
	return cars;
    }

    /* (non-Javadoc)
     * @see de.marcelhodan.blog.springboot.rest.CarServiceI#addCar(de.marcelhodan.blog.springboot.api.model.Car)
     */
    @Override
    @PostMapping(value = CONTEXT_ADD, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addCar(@RequestBody Car carToAdd) {
	LOGGER.info("add {} via {}", carToAdd, fullContextPath(CONTEXT_ADD));
	repository.save(carMapper.carToCarEntity(carToAdd));
    }
}