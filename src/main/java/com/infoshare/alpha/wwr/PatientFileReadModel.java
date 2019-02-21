package com.infoshare.alpha.wwr;

import java.util.List;

public class PatientFileReadModel implements PatientReadModel {


    private InstitutionsRepository institutionsRepository;

    private PatientsRepository patientsRepository;

    public PatientFileReadModel(InstitutionsRepository institutionsRepository, PatientsRepository patientsRepository) {
        this.institutionsRepository = institutionsRepository;
        this.patientsRepository = patientsRepository;
    }

    public PatientFileReadModel() {
        this.institutionsRepository = new InstitutionsRepository();
        this.patientsRepository = new PatientsRepository();
    }

    @Override
    public List<Institution> getNearestPatientFacilitiesByCity(Patient patient) {

        return this.institutionsRepository.findInstitutionsByCity(patient.getAddress().getCity());
    }
}
