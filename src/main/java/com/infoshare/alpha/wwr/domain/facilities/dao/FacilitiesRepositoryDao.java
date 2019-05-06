package com.infoshare.alpha.wwr.domain.facilities.dao;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.utils.exceptions.FacilitiesException;

public interface FacilitiesRepositoryDao {

    void persist(Facilities facilities);

    Facilities getAll();

    void edit(Facility oldFacility, Facility editedFacility) throws FacilitiesException;

    void delete(Facility facility) throws FacilitiesException;

}
