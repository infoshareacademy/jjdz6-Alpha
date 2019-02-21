package com.infoshare.alpha.wwr;

public class Institution {
	
	private String name;
    
	private Address address;

    public Institution(String name, Address address) {
        this.address = address;
        this.name = name;
    }

    public Institution() {
        this.address = new Address();
        this.name = "";
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
