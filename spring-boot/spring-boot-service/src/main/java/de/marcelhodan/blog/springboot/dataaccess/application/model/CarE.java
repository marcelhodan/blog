package de.marcelhodan.blog.springboot.dataaccess.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Car")
@Data
public class CarE {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private String manufacturer;

    public CarE() {
    }

    public CarE(String model, String manufacturer) {
	this.model = model;
	this.manufacturer = manufacturer;
    }

}