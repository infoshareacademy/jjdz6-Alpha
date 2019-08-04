package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQuery;

import java.util.List;

public interface PatientsReadModelDb {

    List<Patient> getAll();

    Patients getByQuery(PatientQuery patientQuery);
}
