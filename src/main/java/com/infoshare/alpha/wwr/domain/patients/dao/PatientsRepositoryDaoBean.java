package com.infoshare.alpha.wwr.domain.patients.dao;

import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientsRepositoryDaoBean implements PatientsRepositoryDao {

	@Inject
	private PatientsJsonStorage storage;

	public void persist(Patients patients) {
        this.storage.save(patients);
    }
	
	public Patients getAll() {
		
		return this.storage.load();
	}
}
