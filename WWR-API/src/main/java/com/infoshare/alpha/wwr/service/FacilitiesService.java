package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.FacilityDao;
import com.infoshare.alpha.wwr.domain.Facility;
import com.infoshare.alpha.wwr.exceptions.IdNotFoundException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class FacilitiesService {

    @Inject
    FacilityDao facilityDao;

    public Facility getById(Long id) throws IdNotFoundException {
        return facilityDao.findById(id).orElseThrow(() -> new IdNotFoundException("Facility with ID " + id + " not found"));
    }

    public List<Facility> getFacilitiesList() {
        return facilityDao.findAll();
    }
}
