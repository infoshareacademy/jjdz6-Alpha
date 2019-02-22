package com.infoshare.alpha.wwr;

import java.util.List;

public class PatientsFileReadModel implements PatientsReadModel {


    private InstitutionsRepository institutionsRepository;

    private PatientsRepository patientsRepository;

    public PatientsFileReadModel(InstitutionsRepository institutionsRepository, PatientsRepository patientsRepository) {
        this.institutionsRepository = institutionsRepository;
        this.patientsRepository = patientsRepository;
    }

    public PatientsFileReadModel() {
        this.institutionsRepository = new InstitutionsRepository();
        this.patientsRepository = new PatientsRepository();
    }

    @Override
    public List<Institution> getNearestPatientFacilitiesByCity(Patient patient) {

        return this.institutionsRepository.findByCity(patient.getAddress().getCity());
    }
}
