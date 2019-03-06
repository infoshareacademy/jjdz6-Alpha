package com.infoshare.alpha.wwr.patients.readModel;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.patients.query.PatientFacilityQuery;
import com.infoshare.alpha.wwr.patients.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientsRepository {

    private List<Patient> patients;

    public PatientsRepository() {

        this.patients = new ArrayList<>();

        patients.add(new Patient("Adam", "Kowalski", new Pesel("01070111234"), new Address("Gdańsk", "Pilotów 23e", "+48 691 957 655")));
        patients.add(new Patient("Anna", "Testowa", new Pesel("15070111234"), new Address("Sopot", "Pilotów 23e", "+48 691 957 655")));
        patients.add(new Patient("Karol", "Kowalski", new Pesel("17070111234"), new Address("Gdynia", "Pilotów 23e", "+48 691 957 655")));
        patients.add(new Patient("Brajan", "Nosacz", new Pesel("18070111234"), new Address("Gdańsk", "Pilotów 23e", "+48 691 957 655")));
        patients.add(new Patient("Dzesika", "Somsiad", new Pesel("19010111234"), new Address("Gdynia", "Pilotów 23e", "+48 691 957 655")));
    }

    public List<Patient> getAllPatients() {

        return patients;
    }




    public Patient getPatientByQuery(PatientFacilityQuery patientQuery) {

        return new Patient();
    }




}
