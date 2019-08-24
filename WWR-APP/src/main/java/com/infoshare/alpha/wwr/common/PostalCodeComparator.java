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
        int facilityDifference = Math.abs(postalCode - facility.getAddress().getPostalCode());
        int comparedFacilityDifference = Math.abs(postalCode - comparedFacility.getAddress().getPostalCode());
        if (facilityDifference < comparedFacilityDifference) {
            return -1;
        } else if (facilityDifference > comparedFacilityDifference) {
            return 1;
        } else {
            return 0;
        }
    }
}
