package com.infoshare.alpha.Patient;

import com.infoshare.alpha.wwr.Address;
import com.infoshare.alpha.wwr.Pesel;
import com.infoshare.alpha.wwr.User;

public class Patient extends User {

    private Address address;
    private Pesel pesel;

    public Patient(String name, String surname, Pesel pesel, Address address) {
        super(name, surname);
        this.pesel = pesel;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
    
    public Pesel getPesel() {
    		return this.pesel;
    }
}
