package com.infoshare.alpha.wwr.domain.patients.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patients")
public class Patient implements Comparable<Patient> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToOne()
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    @OneToOne()
    @JoinColumn(name = "pesel_id", unique = true)
    private Pesel pesel;

    @OneToOne()
    @JoinColumn(name = "parent_id", unique = true)
    private Parent parent;

    public Patient(String name, String surname, Pesel pesel, Address address, Parent parent) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
        this.parent = parent;
    }

    public Patient() {
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

    public Address getAddress() {
        return address;
    }

    public Pesel getPesel() {
        return this.pesel;
    }

    public Parent getParent() {
        return parent;
    }

    @Override
    public String toString() {

        return "Name: " + this.getName() + " Surname : " + this.getSurname() + this.address.toString() + this.pesel + this.parent.toString();
    }

    @Override
    public int compareTo(Patient patient) {
        if (!getSurname().equals(patient.getSurname())) {
            return getSurname().compareTo(patient.getSurname());
        } else if (!getName().equals(patient.getName())) {
            return getName().compareTo(patient.getName());
        } else {
            return pesel.getPesel().compareTo(patient.getPesel().getPesel());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getAddress(), patient.getAddress()) &&
                Objects.equals(getPesel(), patient.getPesel()) &&
                Objects.equals(getParent(), patient.getParent()) &&
                Objects.equals(getName(), patient.getName()) &&
                Objects.equals(getSurname(), patient.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getPesel(), getParent(), getName(), getSurname());
    }
}


