package com.infoshare.alpha.wwr.domain.facilities.entity;

import javax.ejb.Local;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Local
public class Facilities extends Facility{

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
