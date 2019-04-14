//package com.infoshare.alpha.wwr.domain.patients.readmodel;
//
//import com.infoshare.alpha.wwr.di.DI;
//import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
//import com.infoshare.alpha.wwr.domain.patients.query.PatientQuery;
//
//public class PatientsReadModel implements DI {
//
//
//	private PatientsReadModelDb patientsReadModelDb;
//
//	public PatientsReadModel(PatientsReadModelDb patientsReadModelDb) {
//		this.patientsReadModelDb = patientsReadModelDb;
//	}
//
//	public Patients getAll() {
//		return this.patientsReadModelDb.getAll();
//	}
//
//	public Patients getByQuery(PatientQuery query) {
//		return this.patientsReadModelDb.getByQuery(query);
//	}
//
//}
