package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.patients.query.PatientFacilityQuery;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

import java.util.List;

public interface PatientsReadModelDb {

    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient);

    public List<Facility> getPatientFacilitiesByQuery(PatientFacilityQuery query);


}
