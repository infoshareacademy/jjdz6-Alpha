package com.infoshare.alpha.wwr.domain.facilities.query;

import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

import java.util.List;

public class FacilityPatientQuery {

    private Patient patient;

    private List<FacilityQueryField> queryFields;

    public FacilityPatientQuery(Patient patient, List<FacilityQueryField> queryFields) {
        this.patient = patient;
        this.queryFields = queryFields;
    }

    public Patient getPatient() {

        return this.patient;
    }

    public List<FacilityQueryField> getQueryFields() {

        return this.queryFields;
    }

}
