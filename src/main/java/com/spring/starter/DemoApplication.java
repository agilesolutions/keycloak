package com.spring.starter;

import static net.logstash.logback.argument.StructuredArguments.kv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.starter.model.Car;
import com.spring.starter.model.Owner;
import com.spring.starter.model.User;
import com.spring.starter.repository.CarRepository;
import com.spring.starter.repository.OwnerRepository;
import com.spring.starter.repository.UserRepository;

@SpringBootApplication
public class DemoApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired	
	private CarRepository carRepository;

	@Autowired	
	private OwnerRepository ownerRepository;

	@Autowired	
	private UserRepository userRepository;


	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			userRepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			userRepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
			
			logger.info("Added users", kv("type", "SAL"));

			
			Owner owner1 = new Owner("John" , "Johnson");
			Owner owner2 = new Owner("Mary" , "Robinson");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);
			
			logger.info("Added owners", kv("type", "SAL"));
			
			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
			logger.info("Added owners", kv("type", "SAL"));

			
		};
	}	
}
