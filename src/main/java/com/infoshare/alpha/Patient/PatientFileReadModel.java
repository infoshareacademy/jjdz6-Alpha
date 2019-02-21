package com.infoshare.alpha.Patient;

import com.infoshare.alpha.wwr.Institution;
import com.infoshare.alpha.wwr.InstitutionsRepository;
import com.infoshare.alpha.wwr.Patient;
import com.infoshare.alpha.wwr.PatientsRepository;

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
