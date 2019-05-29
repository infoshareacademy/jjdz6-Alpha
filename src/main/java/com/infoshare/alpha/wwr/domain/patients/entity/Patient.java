package com.infoshare.alpha.wwr.domain.patients.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.User;

import java.util.Objects;

public class Patient extends User implements Comparable<Patient> {

    private Address address;
    private Pesel pesel;
    private Parent parent;

    public Patient(String name, String surname, Pesel pesel, Address address, Parent parent) {
        super(name, surname);
        this.pesel = pesel;
        this.address = address;
        this.parent = parent;
    }

    public Patient() {
        super("", "");
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
        return getSurname().compareTo(patient.getSurname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getAddress(), patient.getAddress()) &&
                Objects.equals(getPesel(), patient.getPesel()) &&
                Objects.equals(getParent(), patient.getParent()) &&
                Objects.equals(getName(), patient.getName()) && // TODO koniecznie?
                Objects.equals(getSurname(), patient.getSurname()); // TODO koniecznie
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getPesel(), getParent(), getName(), getSurname()); // TODO konieczne?
    }
}


