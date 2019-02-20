package com.infoshare.alpha.wwr;

import java.math.BigInteger;

public class Patient extends User {

    private Address address;

    public Patient(String name, String surname, BigInteger pesel, Address address) {
        super(name, surname, pesel);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
