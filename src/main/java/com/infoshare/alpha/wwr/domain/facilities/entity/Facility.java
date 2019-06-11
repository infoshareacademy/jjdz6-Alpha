package com.infoshare.alpha.wwr.domain.facilities.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;
import com.infoshare.alpha.wwr.common.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Facility {

    private int id;
    private String name;
    private Address address;
    private Boolean isNfz;
    private List<Service> services = new ArrayList<>();


    public Facility(int id, String name, Address address, List<Service> services) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.services = services;
    }

    public Facility(String name, Address address) {
        this(name, address, 0);
    }

    public Facility(String name, Address address, int id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public Facility(String name, Address address, int id, Boolean isNfz, List<Service> services) {
        this.address = address;
        this.name = name;
        this.id = id;
        this.isNfz = isNfz;
        this.services = services;
    }

    public Facility(String name, Address address, Boolean isNfz) {
        this.address = address;
        this.name = name;
        this.isNfz = isNfz;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public List<Service> getServices() {
        return this.services;
    }

    public Boolean isNfz() {
        return isNfz;
    }

    private String valueOf(boolean isNfz) {
        return isNfz ? "placowka publiczna" : "placowka prywatna";
    }

    @Override
    public String toString() {
        return " Id : " + this.id +
                " Name : " + this.name + this.address.toString() +
                " Nfz : " + valueOf(isNfz) +
                " Services : " + Services.fromList(this.services);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;
        Facility facility = (Facility) o;
        return Objects.equals(getName(), facility.getName()) &&
                Objects.equals(getAddress(), facility.getAddress()) &&
                Objects.equals(isNfz(), facility.isNfz()) &&
                Objects.equals(getServices(), facility.getServices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), isNfz(), getServices());
    }
}

