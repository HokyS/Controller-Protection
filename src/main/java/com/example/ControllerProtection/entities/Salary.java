package com.example.ControllerProtection.entities;

import javax.persistence.*;

@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private User user;

    private double salary;

    public Salary(Long id, User user, double salary) {
        this.id = id;
        this.user = user;
        this.salary = salary;
    }

    public Salary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}