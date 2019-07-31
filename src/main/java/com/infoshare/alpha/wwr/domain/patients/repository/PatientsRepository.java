package com.infoshare.alpha.wwr.domain.patients.repository;

import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

public interface PatientsRepository {

    void add(Patients patients);

    Patient add(Patient patient);
}
