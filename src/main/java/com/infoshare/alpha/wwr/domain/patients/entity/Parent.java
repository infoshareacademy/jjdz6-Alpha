package com.infoshare.alpha.wwr.domain.patients.entity;

import com.infoshare.alpha.wwr.common.Pesel;

import javax.persistence.*;

@Entity
@Table(name = "parents")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "pesel_id", unique = true)
    private Pesel pesel;

    public Parent() {

    }

    public Parent(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Parent(String name, String surname, Pesel pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Pesel getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return " Parent name: " + this.getName() + " ,Parent surname: " + this.getSurname();
    }

}
