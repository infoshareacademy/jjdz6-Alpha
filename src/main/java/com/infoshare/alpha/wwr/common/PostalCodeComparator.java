package com.infoshare.alpha.wwr.common;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import java.util.Comparator;

public class PostalCodeComparator implements Comparator<Facility> {

    private String postalCode;

    public PostalCodeComparator(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public int compare(Facility facility, Facility comparedFacility) {
        int parsedPostalCode = Integer.parseInt(postalCode); // TODO throws Exception
        int facilityDifference = Math.abs(parsedPostalCode - Integer.parseInt(facility.getAddress().getPostalCode()));
        int comparedFacilityDifference = Math.abs(parsedPostalCode - Integer.parseInt(comparedFacility.getAddress().getPostalCode()));
        if (facilityDifference < comparedFacilityDifference) {
            return -1;
        } else if (facilityDifference > comparedFacilityDifference) {
            return 1;
        } else {
            return 0;
        }
    }
}
