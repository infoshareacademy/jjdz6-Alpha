package com.infoshare.alpha.wwr.dao;

import com.infoshare.alpha.wwr.domain.ArchivedFacility;

import java.time.LocalDate;
import java.util.List;

public interface ArchivedFacilityDao {

    List<ArchivedFacility> findByDate(LocalDate date);

    List<ArchivedFacility> findAll();

    ArchivedFacility addArchivedFacility(ArchivedFacility archivedFacility);

}
