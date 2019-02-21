package com.infoshare.alpha.wwr;

public enum PatientAllowedQueryFields {

    CITY("city");

    private String allowedField;

    PatientAllowedQueryFields(String allowedField) {
        this.allowedField = allowedField;
    }
}
