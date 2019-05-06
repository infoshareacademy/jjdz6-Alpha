package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import com.infoshare.alpha.wwr.common.Facilities;
import com.infoshare.alpha.wwr.common.Facility;
import com.infoshare.alpha.wwr.utils.FacilitiesException;

public interface FacilitiesReadModelDb {

    void persist(Facilities facilities);

    Facilities getAll();

    void edit(Facility oldFacility, Facility editedFacility) throws FacilitiesException;

    void delete(Facility facility) throws FacilitiesException;

}
