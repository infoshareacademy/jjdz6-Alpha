package com.infoshare.alpha.wwr;

import java.util.List;

public interface PatientsReadModel {

    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient);

    public List<Facility> getPatientFacilitiesByQuery(PatientFacilityQuery query);


}
