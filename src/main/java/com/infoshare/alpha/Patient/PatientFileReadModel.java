package com.infoshare.alpha.Patient;

import com.infoshare.alpha.wwr.Facility;
import com.infoshare.alpha.wwr.FacilitiesRepository;
import com.infoshare.alpha.wwr.Patient;
import com.infoshare.alpha.wwr.PatientsRepository;

import java.util.List;

public class PatientFileReadModel implements PatientReadModel {


    private FacilitiesRepository institutionsRepository;

    private PatientsRepository patientsRepository;

    public PatientFileReadModel(FacilitiesRepository institutionsRepository, PatientsRepository patientsRepository) {
        this.institutionsRepository = institutionsRepository;
        this.patientsRepository = patientsRepository;
    }

    public PatientFileReadModel() {
        this.institutionsRepository = new FacilitiesRepository();
        this.patientsRepository = new PatientsRepository();
    }

    @Override
    public List<Facility> getNearestPatientFacilitiesByCity(Patient patient) {

        return this.institutionsRepository.getByCity(patient.getAddress().getCity());
    }
}
