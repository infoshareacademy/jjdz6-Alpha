package com.infoshare.alpha.Patient;

import com.infoshare.alpha.wwr.Facility;
import com.infoshare.alpha.wwr.Patient;

import java.util.List;

public interface PatientReadModel {

    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient);
}
