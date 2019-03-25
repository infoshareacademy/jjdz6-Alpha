package com.infoshare.alpha.wwr.domain.facilities.entity;

public class Specialist {

    private String name;
    private String lastName;
    private String specialization;

    public Specialist(String name, String lastName, String specialization) {
        this.name = name;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialization() {
        return specialization;
    }
}
