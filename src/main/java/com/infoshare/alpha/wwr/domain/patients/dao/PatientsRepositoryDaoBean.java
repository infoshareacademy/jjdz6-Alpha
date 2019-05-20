package com.infoshare.alpha.wwr.domain.patients.dao;

import com.infoshare.alpha.wwr.domain.patients.datastorage.PatientsJsonStorage;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientsRepositoryDaoBean implements PatientsRepositoryDao {

    @Inject
    private PatientsJsonStorage storage;

    @Override
    public void save(Patients patients) {
        this.storage.save(patients);
    }

    @Override
    public Patients getAll() {

        return this.storage.load();
    }
}
