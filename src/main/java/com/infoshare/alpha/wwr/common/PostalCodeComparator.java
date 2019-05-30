package com.infoshare.alpha.wwr.common;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import java.util.Comparator;

public class PostalCodeComparator implements Comparator<Facility> {

    private Integer postalCode;

    public PostalCodeComparator(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public int compare(Facility facility, Facility comparedFacility) {
        if ((Math.abs(postalCode - Integer.parseInt(facility.getAddress().getPostalCode()))) > (Math.abs(postalCode - Integer.parseInt(comparedFacility.getAddress().getPostalCode())))) {
            return 1;
        } else if (Math.abs((postalCode - Integer.parseInt(facility.getAddress().getPostalCode()))) < (Math.abs(postalCode - Integer.parseInt(comparedFacility.getAddress().getPostalCode())))) {
            return -1;
        } else {
            return 0;
        }
    }
}
