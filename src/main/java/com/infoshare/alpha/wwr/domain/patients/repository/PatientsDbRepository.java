package com.infoshare.alpha.wwr.domain.patients.repository;

import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientsDbRepository implements PatientsRepository {

    @Inject
	private PatientsJsonStorage storage;
	
//    public PatientsDbRepository(PatientsJsonStorage storage){
//        this.storage = storage;
//    }

    @Override
    public void add(Patients patients) {
        this.storage.save(patients);
    }
}
