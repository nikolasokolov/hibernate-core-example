package com.hibernate.springhibernate;

import com.hibernate.springhibernate.model.Car;
import com.hibernate.springhibernate.model.Wheel;
import com.hibernate.springhibernate.repository.CarRepository;
import com.hibernate.springhibernate.repository.WheelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringHibernateApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WheelRepository wheelRepository;
	@Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Wheel wheel = new Wheel("Wheel Saved");
		wheelRepository.pesist(wheel);
		wheelRepository.save(new Wheel("Wheel Persisted"));
		Wheel wheel2 = new Wheel("Wheel Persisted");
		wheelRepository.save(wheel2);
		Wheel wheel3 = new Wheel("Wheel3");
		wheelRepository.pesist(wheel3);
		Wheel wheel4 = new Wheel("Wheel4");
		wheelRepository.save(wheel4);
		List<Wheel> wheels = new ArrayList<>();
		wheels.add(wheel);
		wheels.add(wheel2);
		wheels.add(wheel3);
		wheels.add(wheel4);
		Car car = new Car("Chevrolet", wheels);
		carRepository.pesist(car);
		carRepository.save(car);
		logger.info("Get car -> " + carRepository.get(1L).getName());
		logger.info("Load car -> " + carRepository.load(1L).getName());
		Car chevrolet = carRepository.findByName("Chevrolet");
		logger.info("Criteria query: Find By Car Name Like -> " + chevrolet.getName());
	}
}