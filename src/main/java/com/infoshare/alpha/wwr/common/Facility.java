package com.infoshare.alpha.wwr.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        this.id = UUID.randomUUID();
    }

    public Facility(String name, Address address) {
        this(name, address, UUID.randomUUID());
    }

    public Facility(String name, Address address, UUID id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public Facility(String name, Address address, UUID id, List<Service> services) {
        this.address = address;
        this.name = name;
        this.id = id;
        this.services = services;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;
        Facility facility = (Facility) o;
        return Objects.equals(getName(), facility.getName()) &&
                Objects.equals(getAddress(), facility.getAddress()) &&
                Objects.equals(getServices(), facility.getServices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getServices());
    }
}