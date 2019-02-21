package com.infoshare.alpha.wwr;

import java.util.List;

public interface PatientReadModel {

    public List<Institution> getNearestPatientFacilitiesByCity(Patient patient);
}
