package com.infoshare.alpha.wwr;

import java.util.List;

public interface PatientsReadModel {

    public List<Institution> getNearestPatientFacilitiesByCity(Patient patient);


}
