package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;

import java.util.List;

 interface FacilitiesReadModelDb {

     List<Facility> getAll();

     Facility getById(int id);

     List<Facility> getByName(String name);

     List<Facility> getByCity(String city);

     List<Facility> getByPatient(FacilityPatientQuery query);

     List<Facility> getByQuery(FacilityQuery query);
}
