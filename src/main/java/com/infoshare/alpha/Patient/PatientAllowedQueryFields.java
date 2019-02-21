package com.infoshare.alpha.Patient;

public enum PatientAllowedQueryFields {

    CITY("city");

    private String allowedField;

    PatientAllowedQueryFields(String allowedField) {
        this.allowedField = allowedField;
    }
}
