package com.infoshare.alpha.wwr.patients.query;

public enum PatientFacilityQueryFields {

    CITY("city"),
    FACILITY_NAME("facility_name");

    private String allowedField;

    PatientFacilityQueryFields(String allowedField) {
        this.allowedField = allowedField;
    }

    @Override
    public String toString() {
        return allowedField;
    }
}
