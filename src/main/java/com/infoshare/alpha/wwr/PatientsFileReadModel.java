package com.infoshare.alpha.wwr;

import java.util.List;

public class PatientsFileReadModel implements PatientsReadModel {

    private FacilitiesRepository institutionsRepository;

    private PatientsRepository patientsRepository;

    public PatientsFileReadModel(FacilitiesRepository institutionsRepository, PatientsRepository patientsRepository) {
        this.institutionsRepository = institutionsRepository;
        this.patientsRepository = patientsRepository;
    }

    public PatientsFileReadModel() {
        this.institutionsRepository = new FacilitiesRepository();
        this.patientsRepository = new PatientsRepository();
    }

    @Override
    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient) {

        return this.institutionsRepository.getByCity(patient.getAddress().getCity());
    }

    @Override
    public List<Facility> getPatientFacilitiesByQuery(PatientFacilityQuery query) {

        return this.institutionsRepository.getByQuery(query);
    }
}
