package com.infoshare.alpha.wwr.facilities.query;

import com.infoshare.alpha.wwr.patients.entity.Patient;

public class FacilityQuery {

    private Patient patient;

    private PatientFacilityQueryFields queryField;

    private String keyword;

    public FacilityQuery(Patient patient, PatientFacilityQueryFields queryField, String keyword) {
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
