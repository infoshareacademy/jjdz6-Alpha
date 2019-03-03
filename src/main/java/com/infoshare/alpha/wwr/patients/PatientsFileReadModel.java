package com.infoshare.alpha.wwr.patients;

import com.infoshare.alpha.wwr.facilities.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.facilities.Facility;

import java.util.ArrayList;
import java.util.List;

public class PatientsFileReadModel implements PatientsReadModel {

    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;

    private PatientsRepository patientsRepository;

    public PatientsFileReadModel(FacilitiesReadModelDbRepository institutionsRepository, PatientsRepository patientsRepository) {
        this.facilitiesReadModelDbRepository = institutionsRepository;
        this.patientsRepository = patientsRepository;
    }

    public PatientsFileReadModel() {
        this.facilitiesReadModelDbRepository = new FacilitiesReadModelDbRepository();
        this.patientsRepository = new PatientsRepository();
    }

    @Override
    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient) {

        return this.facilitiesReadModelDbRepository.getByCity(patient.getAddress().getCity());
    }

    @Override
    public List<Facility> getPatientFacilitiesByQuery(PatientFacilityQuery query) {

        List<Facility> facilitiesCollection;

        PatientFacilityQueryFields field = query.getQueryField();

        switch (field) {
            case CITY:
                facilitiesCollection = this.facilitiesReadModelDbRepository.getByCity(query.getKeyword());
                break;
            case FACILITY_NAME:
                facilitiesCollection = this.facilitiesReadModelDbRepository.getByName(query.getKeyword());
                break;
            default:
                facilitiesCollection = new ArrayList<>();
        }

        return facilitiesCollection;
    }
}
