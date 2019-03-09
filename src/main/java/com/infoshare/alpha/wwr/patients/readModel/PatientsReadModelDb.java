package com.infoshare.alpha.wwr.patients.readModel;

import com.infoshare.alpha.wwr.facilities.entity.Facility;
import com.infoshare.alpha.wwr.patients.query.PatientFacilityQuery;
import com.infoshare.alpha.wwr.patients.entity.Patient;

import java.util.List;

public interface PatientsReadModelDb {

    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient);

    public List<Facility> getPatientFacilitiesByQuery(PatientFacilityQuery query);


}
