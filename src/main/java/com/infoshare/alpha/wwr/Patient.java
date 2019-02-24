package com.infoshare.alpha.wwr;

public class Patient extends User {

    private Address address;
    private Pesel pesel;

    public Patient(String name, String surname, Pesel pesel, Address address) {
        super(name, surname);
        this.pesel = pesel;
        this.address = address;
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
}
