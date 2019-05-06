package com.infoshare.alpha.wwr.domain.patients;

//import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
//import com.infoshare.alpha.wwr.domain.patients.dao.PatientsReadModelDb;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDbRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientsService {

	@Inject
	private PatientsReadModelDbRepository patientsReadModelDbRepository;
//	private PatientsRepository patientsRepository;

	
//	public PatientsService(
//			PatientsReadModelDb patientsReadModelDbRepository,
//			PatientsRepository patientsRepository
//			)
//	{
//		this.patientsReadModelDbRepository = patientsReadModelDbRepository;
//		this.patientsRepository = patientsRepository;
//	}
	
	public void add(Patient patient) {

		Patients patients = this.patientsReadModelDbRepository.getAll();

		patients.add(patient);

		this.patientsReadModelDbRepository.persist(patients);

		System.out.println(patient.toString() + " added. ");
	}
	
	public void edit(Patient patient) {
		// TODO: to implement
	}
	
	public void delete(Patient patient) {
		//TODO: to implement
	}
	
	public void load(String filePath) {
		// TODO: to implement
	}
}
