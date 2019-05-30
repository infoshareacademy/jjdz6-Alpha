package com.infoshare.alpha.wwr.common;

import java.util.Objects;

public class Address {

    private String city;

    private String street;

    private String phone;
    private String postalCode;

    public Address() {
        this.city = "";
        this.street = "";
        this.phone = "";
        this.postalCode = "";
    }

    public Address(String city, String street, String phone, String postalCode) {
        this.city = city;
        this.street = street;
        this.phone = phone;
        this.postalCode = postalCode;
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

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return " City : " + this.city
                + " Postal code: " + this.postalCode
                + " Street : " + this.street
                + " Phone: " + this.phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getPhone(), address.getPhone()) &&
                Objects.equals(getPostalCode(), address.getPostalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getPhone(), getPostalCode());
    }
}
