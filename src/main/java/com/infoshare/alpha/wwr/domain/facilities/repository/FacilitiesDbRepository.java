package com.infoshare.alpha.wwr.domain.facilities.repository;

import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.dao.FacilityDao;
import com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FacilitiesDbRepository implements FacilitiesRepository {

    @Inject
    private FacilitiesJsonStorage storage;

    @Inject
    private FacilityDao facilityDao;

    public void add(Facilities facilities) {
        this.storage.save(facilities);
    }

    @Override
    public void add(Facility facility) {
        facilityDao.add(facility);
    }

    @Override
    public Facility update(Facility facility) {
        return facilityDao.update(facility);
    }

    @Override
    public Facility getById(int id) throws FacilitiesException {
        return facilityDao.getById(id);
    }

    @Override
    public void remove(Facility facility) {
        facilityDao.remove(facility);
    }
}
