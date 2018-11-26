package com.hibernate.springhibernate.repository.Impl;

import com.hibernate.springhibernate.model.Car;
import com.hibernate.springhibernate.repository.CarRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CarRepositoryImpl implements CarRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car findById(Long id) {
        Session session = sessionFactory.openSession();
        Car car = session.get(Car.class, id);
        Hibernate.initialize(car.getId());
        session.close();
        return car;
    }

    @Override
    public void save(Car car) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(car);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void pesist(Car car) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(car);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Car get(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    @Override
    public Car load(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car car = session.load(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    @Override
    public Car findByName(String name) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> root = criteriaQuery.from(Car.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("name"), "%Chevrolet%"));
        criteriaQuery.select(root);
        Query<Car> query = session.createQuery(criteriaQuery);
        Car result = query.getSingleResult();
        return result;
    }

}
