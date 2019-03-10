package com.infoshare.alpha.wwr.domain.patients.entity;

import java.util.ArrayList;
import java.util.List;

public class Patients {

	private List<Patient> patients = new ArrayList<>();

	public void setPatients(List<Patient> patients) {

		this.patients = patients;
	}

	public List<Patient> getPatients() {

		return patients;
	}

	public void add(Patient patient) {

		this.patients.add(patient);
	}

	public void printAllFacilities() {
		for (Patient patient : this.patients) {
			System.out.println(patient.toString());
		}
	}
}
