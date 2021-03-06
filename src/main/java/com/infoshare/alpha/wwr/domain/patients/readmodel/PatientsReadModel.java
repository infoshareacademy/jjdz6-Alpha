package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQuery;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientsReadModel {

    @Inject
    private PatientsReadModelDb patientsReadModelDb;

    public Patients getAll() {
        return this.patientsReadModelDb.getAll();
    }

    public Patients getByQuery(PatientQuery query) {
        return this.patientsReadModelDb.getByQuery(query);
    }

}
