package com.hibernate.springhibernate.model;

import lombok.*;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Wheel.class, fetch = FetchType.EAGER)
    private List<Wheel> wheels;

    public Car(String name, List<Wheel> wheels) {
        this.name = name;
        this.wheels = wheels;
    }

    public Car(String name) {
        this.name = name;
    }
}
