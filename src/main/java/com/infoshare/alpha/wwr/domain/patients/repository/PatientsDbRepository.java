package com.infoshare.alpha.wwr.domain.patients.repository;

import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

public class PatientsDbRepository implements PatientsRepository, DI {

	PatientsJsonStorage storage;
	
    public PatientsDbRepository(PatientsJsonStorage storage){
        this.storage = storage;
    }

    @Override
    public void persist(Patients patients) {
        this.storage.save(patients);
    }

}
