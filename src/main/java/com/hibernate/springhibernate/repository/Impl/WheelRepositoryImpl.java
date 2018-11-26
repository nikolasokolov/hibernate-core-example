package com.hibernate.springhibernate.repository.Impl;

import com.hibernate.springhibernate.model.Wheel;
import com.hibernate.springhibernate.repository.WheelRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WheelRepositoryImpl implements WheelRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Wheel wheel) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(wheel);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Wheel findById(Long id) {
        Session session = sessionFactory.openSession();
        Wheel wheel = session.get(Wheel.class, id);
        Hibernate.initialize(wheel.getId());
        session.close();
        return wheel;
    }

    @Override
    public void pesist(Wheel wheel) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(wheel);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Wheel get(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Wheel wheel = session.get(Wheel.class, id);
        session.getTransaction().commit();
        session.close();
        return wheel;
    }

    @Override
    public Wheel load(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Wheel wheel = session.load(Wheel.class, id);
        session.getTransaction().commit();
        session.close();
        return wheel;
    }
}
