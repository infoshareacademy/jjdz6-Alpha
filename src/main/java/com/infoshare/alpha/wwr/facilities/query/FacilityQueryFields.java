package com.infoshare.alpha.wwr.facilities.query;

public enum FacilityQueryFields {

    CITY("city"),
    FACILITY_NAME("facility_name");

    private String allowedField;

    FacilityQueryFields(String allowedField) {
        this.allowedField = allowedField;
    }

    @Override
    public String toString() {
        return allowedField;
    }
}
