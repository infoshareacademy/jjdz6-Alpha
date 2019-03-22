package com.infoshare.alpha.wwr.domain.facilities.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.common.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Facility {

    private UUID id;

	private String name;
    
	private Address address;

	private List<Service> services = new ArrayList<>();


	public Facility(String name, Address address, List<Service> services) {
        this.address = address;
        this.name = name;
        this.services = services;
    }

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

    public List<Service> getServices() {
        return this.services;
    }

    @Override
    public String toString() {
    	return "Id: " + this.id.toString() + " Name : " + this.name + this.address.toString() + " Facilities : " + Services.fromList(this.services) ;
    }

}