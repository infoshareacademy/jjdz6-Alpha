package com.infoshare.alpha.wwr.domain.patients.dao;

import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

public interface PatientsRepositoryDao {

    void save(Patients patients);

    Patients getAll();

}
