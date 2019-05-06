package com.infoshare.alpha.wwr.domain.patients.dao;

import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

public interface PatientsRepositoryDao {

	public void persist(Patients patients);

	public Patients getAll();

}
