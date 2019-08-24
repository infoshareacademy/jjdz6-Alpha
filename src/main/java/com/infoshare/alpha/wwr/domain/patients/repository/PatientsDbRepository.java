package com.infoshare.alpha.wwr.domain.patients.repository;

import com.infoshare.alpha.wwr.domain.patients.dao.PatientDao;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientsDbRepository implements PatientsRepository {

    @Inject
    private PatientDao patientDao;

    @Override
    public Patient add(Patient patient) {
        return patientDao.add(patient);
    }
}
