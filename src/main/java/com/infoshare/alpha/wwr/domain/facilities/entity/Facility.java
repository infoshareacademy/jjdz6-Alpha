package com.infoshare.alpha.wwr.domain.facilities.entity;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Facility")
@Table(name = "facilities")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne()
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    @Column(name = "is_nfz")
    private Boolean isNfz;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "facilities_services",
            joinColumns = { @JoinColumn(name = "facility_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") }
    )
    private List<Service> services = new ArrayList<>();

    public Facility() {
    }

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

    public Facility(String name, Address address, Boolean isNfz, List<Service> services) {
        this.address = address;
        this.name = name;
        this.isNfz = isNfz;
        this.services = services;
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
        return services;
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
                " Nfz : " + valueOf(isNfz);
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

