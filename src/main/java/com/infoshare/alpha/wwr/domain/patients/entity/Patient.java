package com.infoshare.alpha.wwr.domain.patients.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.User;

public class Patient extends User {

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
}


