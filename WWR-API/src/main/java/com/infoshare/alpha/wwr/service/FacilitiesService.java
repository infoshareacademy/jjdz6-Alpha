package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.FacilityDao;
import com.infoshare.alpha.wwr.domain.Facility;
import com.infoshare.alpha.wwr.exceptions.FacilityNotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class FacilitiesService {

    @Inject
    FacilityDao facilityDao;

    public Facility getById(Long id) throws FacilityNotFoundException {
        return facilityDao.findById(id).orElseThrow(() -> new FacilityNotFoundException("Facility with ID " + id + " not found"));
    }

    public List<Facility> getFacilitiesList() {
        return facilityDao.findAll();
    }
}
