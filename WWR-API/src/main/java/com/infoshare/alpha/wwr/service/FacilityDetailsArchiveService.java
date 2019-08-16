package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.FacilityDetailsArchiveDao;
import com.infoshare.alpha.wwr.domain.FacilityDetailsArchive;
import com.infoshare.alpha.wwr.entities.Facility;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class FacilityDetailsArchiveService {

    @Inject
    Logger logger;

    @Inject
    FacilityDetailsArchiveDao facilityDetailsArchiveDao;

    @Inject
    FacilitiesService facilitiesService;

//    public com.infoshare.alpha.wwr.domain.FacilityDetailsArchive getById(Long id) {
//        if (facilityDetailsArchiveDao.findById(id).isPresent()) {
//            return facilityDetailsArchiveDao.findById(id).get();
//        } else {
//            logger.warn("FacilityDetailsArchive with ID: {} has not been found.", id);
//            throw new ResourceNotFoundException("FacilityDetailsArchive with ID " + id + " not found");
//        }
//    }

    public List<FacilityDetailsArchive> getArchivedFacilityDetailsByFacilityId(int id) {
//        return facilitiesService.getById(id).getFacilityDetailsArchive();
        return facilityDetailsArchiveDao.findAll()
                .stream()
                .filter(f -> f.getCurrentFacility().getId() == id)
                .collect(Collectors.toList());
    }

    public List<FacilityDetailsArchive> getArchivedFacilityDetailsByDate(LocalDate date) {
        return facilityDetailsArchiveDao.findByDate(date);
    }

    public List<FacilityDetailsArchive> getArchivedFacilityDetailsList() {
        return facilityDetailsArchiveDao.findAll();
    }


    public FacilityDetailsArchive addFacilityDetails(Facility facility) { //TODO refactor + set current facility?
        FacilityDetailsArchive facilityDetailsArchive = new FacilityDetailsArchive();
        Facility currentFacility = facilitiesService.getById(facility.getId());

        facilityDetailsArchive.setArchivedFacility(facility);
        facilityDetailsArchive.setCurrentFacility(currentFacility);
        return facilityDetailsArchiveDao.addFacilityDetails(facilityDetailsArchive);
    }
}
