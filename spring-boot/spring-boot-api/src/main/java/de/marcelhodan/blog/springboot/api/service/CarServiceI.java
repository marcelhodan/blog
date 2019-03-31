package de.marcelhodan.blog.springboot.api.service;

import java.util.List;

import de.marcelhodan.blog.springboot.api.model.Car;

public interface CarServiceI {

    List<Car> listAllCars();

    void addCar(Car carToAdd);

}