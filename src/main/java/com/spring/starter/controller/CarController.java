package com.spring.starter.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.starter.exceptions.CarNotFoundException;
import com.spring.starter.model.Car;
import com.spring.starter.repository.CarRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class CarController {
	@Autowired
	private CarRepository repository;

	@RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/cars")
	@ApiOperation(value = "List cars", notes = "List all available cars")
	public Iterable<Car> getCars() {
		return repository.findAll();
	}

	@RolesAllowed({"ROLE_ADMIN"})
	@ApiOperation(value = "Add new Cars")
	@PostMapping("/cars")
	public Car login(@ApiParam(value = "Add new Car") @RequestBody Car car) {

		return repository.save(car);

	}

	@RolesAllowed({"ROLE_ADMIN"})
	@ApiOperation(value = "Remove car")
	@DeleteMapping("/cars/{id}")
	void deleteEmployee(@ApiParam(value = "Car identifier") @PathVariable Long id) {
		repository.deleteById(id);
	}

	// Single item

	@RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/cars/{id}")
	Car one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
	}

}
