package com.infoshare.alpha.wwr.facilities.query;

import com.infoshare.alpha.wwr.patients.entity.Patient;

public class FacilityPatientQuery extends FacilityQuery {

	private Patient patient;
	
	public FacilityPatientQuery(Patient patient, FacilityQueryFields queryField, String keyword) {
		super(queryField, keyword);
		this.patient = patient;
	}
	
	public Patient getPatient() {
		
		return this.patient;
	}

	

}
