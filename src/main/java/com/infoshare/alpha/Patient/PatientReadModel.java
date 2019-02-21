package com.infoshare.alpha.Patient;

import com.infoshare.alpha.wwr.Institution;
import com.infoshare.alpha.wwr.Patient;

import java.util.List;

public interface PatientReadModel {

    public List<Institution> getNearestPatientFacilitiesByCity(Patient patient);
}
