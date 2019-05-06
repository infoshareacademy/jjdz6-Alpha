package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import java.util.List;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Facilities;
import com.infoshare.alpha.wwr.common.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;

public interface FacilitiesReadModelDb {

    public void persist(Facilities facilities);

    public Facilities getAll();

    public List<Facility> getByName(String name);

    public List<Facility> getByCity(String city);

    public List<Facility> getByAddress(Address address);

    public List<Facility> getByPatient(FacilityPatientQuery query);

    public List<Facility> getByQuery(FacilityQuery query);
}
