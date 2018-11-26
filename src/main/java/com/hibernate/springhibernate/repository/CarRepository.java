package com.hibernate.springhibernate.repository;

import com.hibernate.springhibernate.model.Car;

public interface CarRepository {
    Car findById(Long id);
    void save(Car car);
    void pesist(Car car);
    Car get(Long id);
    Car load(Long id);
    Car findByName(String name);
}
