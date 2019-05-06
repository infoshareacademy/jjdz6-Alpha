package com.infoshare.alpha.wwr.domain.facilities.dao;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.utils.FacilitiesException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FacilitiesRepositoryDaoBean implements FacilitiesRepositoryDao {

    @Inject
    private FacilitiesJsonStorage storage;

    @Override
    public void persist(Facilities facilities) {
        this.storage.save(facilities);
    }

    @Override
    public Facilities getAll() {

        return this.storage.load();
    }

    @Override
    public void edit(Facility oldFacility, Facility editedFacility) throws FacilitiesException {

        Facilities facilities = storage.load();
        Integer oldFacilityIndex;
        if (facilities.getFacilities().contains(oldFacility)) {
            oldFacilityIndex = facilities.getFacilities().indexOf(oldFacility);
        } else {
            throw FacilitiesException.facilityNotFound(oldFacility.getName());
        }
        for (Facility facility : facilities.getFacilities()) {
            if (facility.equals(editedFacility)) {
                throw FacilitiesException.facilityExists(editedFacility.getName());
            }
        }
        facilities.getFacilities().remove(oldFacility);
        facilities.getFacilities().add(oldFacilityIndex, editedFacility);
        storage.save(facilities);

    }

    @Override
    public void delete(Facility facility) throws FacilitiesException {

        Facilities facilities = storage.load();
        if (facilities.getFacilities().contains(facility)) {
            facilities.getFacilities().remove(facility);
            storage.save(facilities);
        } else {
            throw FacilitiesException.facilityNotFound(facility.getName());
        }
    }
}
