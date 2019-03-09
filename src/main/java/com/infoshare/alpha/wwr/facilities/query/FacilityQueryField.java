package com.infoshare.alpha.wwr.facilities.query;

public enum FacilityQueryField {

    CITY("city"),
    STREET("street"),
    PHONE("phone"),
    FACILITY_NAME("facility_name");

    private String allowedField;

    FacilityQueryField(String allowedField) {
        this.allowedField = allowedField;
    }

    @Override
    public String toString() {
        return allowedField;
    }
}
