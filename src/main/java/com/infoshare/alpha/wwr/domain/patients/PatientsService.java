package com.infoshare.alpha.wwr.domain.patients;

import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDb;
import com.infoshare.alpha.wwr.domain.patients.repository.PatientsRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientsService {

    @Inject
    private PatientsReadModelDb patientsReadModelDbRepository;
    @Inject
    private PatientsRepository patientsRepository;

    public void add(Patient patient) {

        Patients patients = this.patientsReadModelDbRepository.getAll();

        patients.add(patient);

        this.patientsRepository.add(patients);
    }

    public void edit(Patient patient) {
        // TODO: to implement
    }

    public void delete(Patient patient) {
        //TODO: to implement
    }

    public void load(String filePath) {
        // TODO: to implement
    }
}
