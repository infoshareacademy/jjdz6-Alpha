package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.FacilityDetailsArchive;

import java.time.LocalDate;
import java.util.List;

public interface FacilityDetailsArchiveDao {

//    Optional<FacilityDetailsArchive> findById(Long id);

    List<FacilityDetailsArchive> findByDate(LocalDate date);

    List<FacilityDetailsArchive> findAll();

    FacilityDetailsArchive addFacilityDetails(FacilityDetailsArchive facilityDetailsArchive);

}
