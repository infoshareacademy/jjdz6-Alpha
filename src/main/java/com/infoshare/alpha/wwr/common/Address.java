package com.infoshare.alpha.wwr.common;

public class Address {

    private String city;

    private String street;

    private String phone;

    public Address() {
        this.city = "";
        this.street = "";
        this.phone = "";
    }

    public Address(String city, String street, String phone) {
        this.city = city;
        this.street = street;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPhone() {
        return phone;
    }
    
    @Override
    public String toString() {
    		return " City : " + this.city + " Street : " + this.street + " Phone: " + this.phone;
    }
}
