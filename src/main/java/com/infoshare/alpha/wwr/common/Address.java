package com.infoshare.alpha.wwr.common;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "postalCode", nullable = false)
    private int postalCode;

    public Address(String city, String street, String phone, int postalCode) {
        this.city = city;
        this.street = street;
        this.phone = phone;
        this.postalCode = postalCode;
    }

    public int getId() { return id; }

    public String getCity() { return city; }

    public String getStreet() {
        return street;
    }

    public String getPhone() {
        return phone;
    }

    public int getPostalCode() {
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
