package de.marcelhodan.blog.springboot.api.model;

import lombok.Data;

@Data
public class Car {

    private String model;
    private String manufacturer;

    public Car() {
    }

    public Car(String model, String manufacturer) {
	this.model = model;
	this.manufacturer = manufacturer;
    }

}