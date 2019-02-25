package com.infoshare.alpha.wwr;

import java.util.ArrayList;
import java.util.List;

public class PatientsFileReadModel implements PatientsReadModel {

    private FacilitiesRepository facilitiesRepository;

    private PatientsRepository patientsRepository;

    public PatientsFileReadModel(FacilitiesRepository institutionsRepository, PatientsRepository patientsRepository) {
        this.facilitiesRepository = institutionsRepository;
        this.patientsRepository = patientsRepository;
    }

    public PatientsFileReadModel() {
        this.facilitiesRepository = new FacilitiesRepository();
        this.patientsRepository = new PatientsRepository();
    }

    @Override
    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient) {

        return this.facilitiesRepository.getByCity(patient.getAddress().getCity());
    }

    @Override
    public List<Facility> getPatientFacilitiesByQuery(PatientFacilityQuery query) {

        List<Facility> facilitiesCollection;

        PatientFacilityQueryFields field = query.getQueryField();

        switch (field) {
            case CITY:
                facilitiesCollection = this.facilitiesRepository.getByCity(query.getKeyword());
                break;
            case FACILITY_NAME:
                facilitiesCollection = this.facilitiesRepository.getByName(query.getKeyword());
                break;
            default:
                facilitiesCollection = new ArrayList<Facility>();
        }

        return facilitiesCollection;
    }
}
