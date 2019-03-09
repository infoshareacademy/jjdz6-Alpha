package com.infoshare.alpha.wwr.facilities.query;

import com.infoshare.alpha.wwr.patients.entity.Patient;

import java.util.List;

public class FacilityPatientQuery extends FacilityQuery {

	private Patient patient;
	
	public FacilityPatientQuery(Patient patient, List<FacilityQueryFields> queryFields) {
		super(queryFields, "");
		this.patient = patient;
	}
	
	public Patient getPatient() {
		
		return this.patient;
	}

	

}
