package com.infoshare.alpha.wwr.facilities.readmodel;

import java.util.List;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.facilities.entity.Facility;
import com.infoshare.alpha.wwr.facilities.query.FacilityPatientQuery;

public interface FacilitiesReadModelDb {

    public Facilities getAll();

    public List<Facility> getByName(String name);

    public List<Facility> getByCity(String city);
    
    public List<Facility> getByAddress(Address address);

    List<Facility> getByPatient(FacilityPatientQuery query);
}
