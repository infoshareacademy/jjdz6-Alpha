package com.infoshare.alpha.wwr;

public class Institution {

    private Address address;

    private String name;

    public Institution(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Institution() {
        this.address = new Address();
        this.name = "";
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
