package com.infoshare.alpha.wwr.domain.patients.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.User;

public class Patient extends User {

    private Address address;
    private Pesel pesel;
    private Caretaker caretaker;

    public Patient(String name, String surname, Pesel pesel, Address address, Caretaker caretaker) {
        super(name, surname);
        this.pesel = pesel;
        this.address = address;
        this.caretaker = caretaker;
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

    public Caretaker getCaretaker() {
        return caretaker;
    }

    @Override
    public String toString() {

    	return "Name: " + this.getName() + " Surname : " + this.getSurname() + this.address.toString() + this.pesel + this.caretaker.toString();
    }
}
