package com.infoshare.alpha.wwr.domain.patients;

import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDb;
import com.infoshare.alpha.wwr.domain.patients.repository.PatientsRepository;


public class PatientsService {

	private PatientsReadModelDb patientsReadModelDbRepository;
	private PatientsRepository patientsRepository;
	
	public PatientsService(
			PatientsReadModelDb patientsReadModelDbRepository,
			PatientsRepository patientsRepository
			) 
	{
		this.patientsReadModelDbRepository = patientsReadModelDbRepository;
		this.patientsRepository = patientsRepository;
	}
	
	public void add(Patient patient) {
		//TODO: to implement
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
