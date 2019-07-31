package com.infoshare.alpha.wwr.domain.patients.repository;

import com.infoshare.alpha.wwr.domain.patients.dao.PatientDao;
import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientsDbRepository implements PatientsRepository {

    @Inject
    private PatientsJsonStorage storage;

    @Inject
    private PatientDao patientDao;

    @Override
    public void add(Patients patients) {
        this.storage.save(patients);
    }

    @Override
    public Patient add(Patient patient) {
        return patientDao.add(patient);
    }
}
