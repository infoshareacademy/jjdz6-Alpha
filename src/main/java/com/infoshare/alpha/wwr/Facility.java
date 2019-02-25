package com.infoshare.alpha.wwr;

public class Facility {
	
	private String name;
    
	private Address address;

    public Facility(String name, Address address) {
        this.address = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public Address getAddress() {
        return address;
    }
    
    @Override
    public String toString()
    {
    		return " Name : " + this.name + this.address.toString();   	
    }

}
