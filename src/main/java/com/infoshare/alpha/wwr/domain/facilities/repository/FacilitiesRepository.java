package com.infoshare.alpha.wwr.domain.facilities.repository;

import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;

public interface FacilitiesRepository {

    void add(Facility facility);

    void add(Facilities facilities);

    Facility update(Facility facility);

    Facility getById(int id) throws FacilitiesException;

    void remove(Facility facility);
}
