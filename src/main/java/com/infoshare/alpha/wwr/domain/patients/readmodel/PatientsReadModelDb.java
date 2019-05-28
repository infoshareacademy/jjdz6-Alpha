package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQuery;

public interface PatientsReadModelDb {

    public Patients getAll();

    public Patients getByQuery(PatientQuery patientQuery);
}
