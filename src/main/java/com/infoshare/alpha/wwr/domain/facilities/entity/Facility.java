package com.infoshare.alpha.wwr.domain.facilities.entity;

import com.infoshare.alpha.Specialist;

public class Facility {

    private String name;
    private String street;
    private String city;
    private String postalCode;
    private String telephoneNumber;
    private boolean isPrivate;
    private Specialist specialist;

    public Facility() {
    }

    public Facility(String name, String street, String city, String postalCode, String telephoneNumber, boolean isPrivate, Specialist specialist) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.telephoneNumber = telephoneNumber;
        this.isPrivate = isPrivate;
        this.specialist = specialist;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public Specialist getSpecialist() {
        return specialist;
    }
}