package com.infoshare.alpha.wwr.patients;

import com.infoshare.alpha.wwr.facilities.entity.Facility;

import java.util.List;

public interface PatientsReadModel {

    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient);

    public List<Facility> getPatientFacilitiesByQuery(PatientFacilityQuery query);


}
