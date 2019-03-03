package com.infoshare.alpha.wwr.patients;

public class PatientFacilityQuery {

    private Patient patient;

    private PatientFacilityQueryFields queryField;

    private String keyword;

    public PatientFacilityQuery(Patient patient, PatientFacilityQueryFields queryField, String keyword) {
        this.patient = patient;
        this.queryField = queryField;
        this.keyword = keyword;
    }

    public Patient getPatient() {

        return patient;
    }

    public PatientFacilityQueryFields getQueryField() {
        return queryField;
    }

    public String getKeyword() {
        return keyword;
    }
}
