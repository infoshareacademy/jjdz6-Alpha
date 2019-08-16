package com.infoshare.alpha.wwr.domain.facilities.entity;

import com.infoshare.alpha.wwr.entities.Facility;

import java.util.ArrayList;
import java.util.List;

public class Facilities {

    private List<Facility> facilities = new ArrayList<>();

    public Facilities() {
    }

    public void setFacilities(List<Facility> facilities) {

        this.facilities = facilities;
    }

    public List<Facility> getFacilities() {

        return facilities;
    }

    public void add(Facility facility) {

        this.facilities.add(facility);
    }

    public void printAllFacilities() {

        for (Facility facility : this.facilities) {
            System.out.println(facility.toString());
        }
    }
}
