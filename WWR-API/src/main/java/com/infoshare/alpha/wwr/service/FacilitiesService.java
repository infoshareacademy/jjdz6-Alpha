package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.FacilityDao;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class FacilitiesService {

    @Inject
    Logger logger;

    @Inject
    FacilityDao facilityDao;

    public Facility getById(int id) {
        if (facilityDao.findById(id).isPresent()) {
            return facilityDao.findById(id).get();
        } else {
            logger.warn("Facility with ID: {} has not been found.", id);
            throw new ResourceNotFoundException("Facility with ID " + id + " not found");
        }
    }

    public List<Facility> getFacilitiesList() {
        return facilityDao.findAll();
    }
}
