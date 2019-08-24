package com.infoshare.alpha.wwr.domain.patients.query;

public enum PatientQueryFields {

    NAME("name"),
    SURNAME("surname"),
    PESEL("pesel"),
    CITY("city"),
    STREET("street"),
    PHONE("phone");

    private String allowedField;

    PatientQueryFields(String allowedField) {
        this.allowedField = allowedField;
    }

    @Override
    public String toString() {
        return allowedField;
    }
}
