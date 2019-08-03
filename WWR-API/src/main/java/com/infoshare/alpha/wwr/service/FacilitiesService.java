package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.FacilityDao;
import com.infoshare.alpha.wwr.domain.Facility;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class FacilitiesService {

    @Inject
    FacilityDao facilityDao;

    public Facility getById(int id) {
//        return facilityDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Facility with ID " + id + " not found"));
        if (facilityDao.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Facility with ID " + id + " not found");
        } else {
            return facilityDao.findById(id).get();
        }
    }

    public List<Facility> getFacilitiesList() {
        return facilityDao.findAll();
    }
}
