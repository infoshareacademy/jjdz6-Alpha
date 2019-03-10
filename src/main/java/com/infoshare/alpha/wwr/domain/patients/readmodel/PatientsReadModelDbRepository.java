package com.infoshare.alpha.wwr.domain.patients.readmodel;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.domain.patients.query.FacilityQuery;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientsReadModelDbRepository {

    private List<Patient> patients;

    public PatientsReadModelDbRepository() {

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

    public Patient getPatientByQuery(FacilityQuery patientQuery) {

        return new Patient();
    }

}
