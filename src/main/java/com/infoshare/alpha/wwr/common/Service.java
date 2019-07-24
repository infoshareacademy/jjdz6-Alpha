package com.infoshare.alpha.wwr.common;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Patient> patients = new ArrayList<>();

    @ManyToMany(mappedBy = "services", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Facility> facilities = new ArrayList<>();

    public Service() {
    }

    public Service(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return Objects.equals(getName(), service.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
