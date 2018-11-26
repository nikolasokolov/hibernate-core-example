package com.hibernate.springhibernate.repository;

import com.hibernate.springhibernate.model.Wheel;

public interface WheelRepository {
    void save(Wheel wheel);
    Wheel findById(Long id);
    void pesist(Wheel wheel);
    Wheel get(Long id);
    Wheel load(Long id);
}
