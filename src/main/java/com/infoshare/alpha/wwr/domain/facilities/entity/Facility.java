package com.infoshare.alpha.wwr.domain.facilities.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.common.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Facility {

    private UUID id;
    private String name;
    private Address address;
    private Boolean NFZ;
    private List<Service> services = new ArrayList<>();


    public Facility(String name, Address address, List<Service> services) {
        this.address = address;
        this.name = name;
        this.services = services;
        this.id = UUID.randomUUID();
    }

    public Facility() {
        this(name, address, UUID.randomUUID());
    }

    public Facility(String name, Address address, UUID id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public Facility(String name, Address address, UUID id, Boolean NFZfacility, <Service>services) {
        this.address = address;
        this.name = name;
        this.id = id;
        this.NFZfacility = NFZfacility;
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public List<Service> getServices() {
        return this.services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Boolean getNFZ() {
        return NFZfacility;
    }

    public void setNFZ(Boolean NFZfacility) {
        this.NFZfacility = NFZfacility;
    }

    @Override
    public String toString() {
        return "Id: " + this.id.toString() + " Name : " + this.name + this.address.toString() + " Facilities : " + Services.fromList(this.services);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;
        Facility facility = (Facility) o;
        return Objects.equals(getName(), facility.getName()) &&
                Objects.equals(getAddress(), facility.getAddress()) &&
                Objects.equals(getServices(), facility.getServices()) &&
                Objects.equals(getNFZ(), facility.getNFZ());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getServices(), getNFZ());
    }
}