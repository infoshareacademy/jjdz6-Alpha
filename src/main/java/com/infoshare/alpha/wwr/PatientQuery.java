package com.infoshare.alpha.wwr;
// not user yet
public class PatientQuery {

    private Patient patient;

    private PatientAllowedQueryFields queryField;

    public PatientQuery(Patient patient, PatientAllowedQueryFields findByField) {
        this.patient = patient;
        this.queryField = findByField;
    }

    public Patient getPatient() {
        return patient;
    }

    public PatientAllowedQueryFields getQueryField() {
        return queryField;
    }
}
