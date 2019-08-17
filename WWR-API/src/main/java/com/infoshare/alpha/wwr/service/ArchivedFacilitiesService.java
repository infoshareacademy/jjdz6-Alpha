package com.infoshare.alpha.wwr.service;

import com.infoshare.alpha.wwr.dao.ArchivedFacilityDao;
import com.infoshare.alpha.wwr.domain.ArchivedFacility;
import com.infoshare.alpha.wwr.entities.Facility;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@RequestScoped
public class ArchivedFacilitiesService {

    @Inject
    Logger logger;

    @Inject
    ArchivedFacilityDao archivedFacilityDao;

    @Inject
    FacilitiesService facilitiesService;

//    TODO add facility id as arg?
//    public List<ArchivedFacility> getArchivedFacilityByDate(LocalDate date) {
//        return archivedFacilityDao.findByDate(date);
//    }

    public List<ArchivedFacility> getArchivedFacilities() {
        return archivedFacilityDao.findAll();
    }


    public ArchivedFacility addArchivedFacility(ArchivedFacility archivedFacility) {
        return archivedFacilityDao.addArchivedFacility(archivedFacility);
    }

//    TODO
//    public ArchivedFacility addArchivedFacility(Facility facility) {
//        ArchivedFacility archivedFacility = new ArchivedFacility(facility);
//        return archivedFacilityDao.addArchivedFacility(archivedFacility);
//    }
}
