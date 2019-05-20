package com.infoshare.alpha.wwr.domain.facilities.repository;

import com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FacilitiesDbRepository implements FacilitiesRepository {

    @Inject
	private FacilitiesJsonStorage storage;
	
//    public FacilitiesDbRepository(){
//        this.storage = storage;
//    }

    public void persist(Facilities facilities) {
        this.storage.save(facilities);
    }
}
