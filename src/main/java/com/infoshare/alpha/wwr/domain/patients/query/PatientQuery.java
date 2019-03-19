package com.infoshare.alpha.wwr.domain.patients.query;

import java.util.Map;

import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

public class PatientQuery {

    private Patient patient;

    private Map<PatientQueryFields,String> queryFields;


    public PatientQuery(Patient patient, Map<PatientQueryFields, String> queryFields) {
        this.patient = patient;
        this.queryFields = queryFields;
   }

    public Patient getPatient() {

        return patient;
    }

    public Map<PatientQueryFields, String> getQueryField() {
    	
        return queryFields;
    }


}