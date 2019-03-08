package com.infoshare.alpha.wwr.facilities.entity;

import com.infoshare.alpha.wwr.common.Address;

import java.util.UUID;

public class Facility {

    private UUID id;

	private String name;
    
	private Address address;

    public Facility(String name, Address address) {
        this(name, address, UUID.randomUUID());
    }

    public Facility(String name, Address address, UUID id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public String getName() {
 
    	return name;
    }
    
    public Address getAddress() {

    	return address;
    }

    public UUID getId() {
 
    	return id;
    }

    @Override
    public String toString() {

    	return "Id: " + this.id.toString() + " Name : " + this.name + this.address.toString();
    }

}