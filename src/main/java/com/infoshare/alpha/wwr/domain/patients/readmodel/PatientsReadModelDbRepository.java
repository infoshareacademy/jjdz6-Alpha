package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

public class PatientsReadModelDbRepository implements DI {

	private PatientsJsonStorage storage;
	
	public PatientsReadModelDbRepository(PatientsJsonStorage storage) {	
        try {
            this.storage = storage;
        } catch (NullPointerException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
	}
	
	public Patients getAll() {
		
		return this.storage.load();
	}

}
