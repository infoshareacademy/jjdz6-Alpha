package com.infoshare.alpha.Patient;

import com.infoshare.alpha.wwr.Patient;

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
