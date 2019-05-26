package com.infoshare.alpha.wwr.common;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getPhone(), address.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getPhone());
    }
}
