package com.infoshare.alpha.wwr.domain.patients.repository;

import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

public interface PatientsRepository {

    public void persist(Patients patients);

}
