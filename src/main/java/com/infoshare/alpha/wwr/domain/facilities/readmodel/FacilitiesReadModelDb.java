package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import java.util.List;
import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;


interface FacilitiesReadModelDb {

    Facilities getAll();

    Facility getById(int id);

    List<Facility> getByName(String name);

    List<Facility> getByCity(String city);

    List<Facility> getByAddress(Address address);

    List<Facility> getByPatient(FacilityPatientQuery query);

    List<Facility> getByQuery(FacilityQuery query);
}
