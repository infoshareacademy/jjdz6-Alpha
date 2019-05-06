package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import com.infoshare.alpha.wwr.common.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FacilitiesReadModelDbRepository implements FacilitiesReadModelDb {

    @Inject
    private FacilitiesJsonStorage storage;

    public void persist(Facilities facilities) {
        this.storage.save(facilities);
    }

    public Facilities getAll() {
        
        return this.storage.load();
    }
}
