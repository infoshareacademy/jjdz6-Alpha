package com.infoshare.alpha.wwr.facilities.repository;

import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;

public class FacilitiesDbRepository implements FacilitiesRepository, DI {

	FacilitiesJsonStorage storage;
	
    public FacilitiesDbRepository(FacilitiesJsonStorage storage){
        this.storage = storage;
    }

    public void persist(Facilities facilities) {
        this.storage.save(facilities);
    }
}
