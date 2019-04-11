package com.infoshare.alpha.wwr.utils;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModel;
import java.util.*;
import java.util.stream.Collectors;

public class PatientsFacilitiesController {

    private FacilitiesReadModel facilitiesReadModel;
    private PatientsReadModel patientsReadModel;

    public PatientsFacilitiesController(FacilitiesReadModel facilitiesReadModel, PatientsReadModel patientsReadModel) {
        this.facilitiesReadModel = facilitiesReadModel;
        this.patientsReadModel = patientsReadModel;
    }

    public void findPatientsFacilities() {
        try {
            Patient selectedPatient = this.getSelectedPatient(this.patientsReadModel.getAll().getPatients());
            List<Facility> nearestPatientFacilities = this.getFacilitiesBySelectedPatient(selectedPatient);

            this.showPatientFacilities(nearestPatientFacilities);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showPatientFacilities(List<Facility> facilities) {
        System.out.println("-------------------------------------------------");
        System.out.println("Patients nearest facilities");
        System.out.println("-------------------------------------------------");

        /*
            Map<UUID, String> collect = facilities.stream()
                .collect(Collectors.toMap(facility -> facility.getId(), facility -> facility.getName()));
        */

        if (facilities.size() > 0) {
            int ids = 0;
            Map<Integer, Facility> patientFacilitiesMap = new HashMap<>();
            for (Facility facility : facilities) {
                System.out.println(" [ " + ids + " ] " + facility.getName());
                patientFacilitiesMap.put(ids, facility);
                ids++;
            }

            this.showSelectedFacilityDetails(patientFacilitiesMap);


        } else {
            System.out.println("[!] [ No facilities found. ]");
        }
        System.out.println("-------------------------------------------------");
    }

    private void showSelectedFacilityDetails(Map<Integer, Facility> patientFacilitiesMap) {
        boolean facilityDetailsDisplayed = false;
        while (!facilityDetailsDisplayed) {
            System.out.println("Select facility to show details: ");
            try {
                int selectedFacilityId = Menu.getConsoleNumberInput();
                if (patientFacilitiesMap.containsKey(selectedFacilityId)) {
                    Facility selectedFacility = patientFacilitiesMap.get(selectedFacilityId);
                    System.out.println("------------Facility details : ------------------------");
                    System.out.println(selectedFacility);
                    facilityDetailsDisplayed = true;
                } else {
                    System.out.println("Wrong facility number selected. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong facility number selected. Try again.");
            }
        }
    }

    private List<Facility> getFacilitiesBySelectedPatient(Patient selectedPatient) {
        List<FacilityQueryField> facilityQueryFields = new ArrayList<>();
        facilityQueryFields.add(FacilityQueryField.CITY);

        return this.facilitiesReadModel.getByPatient(new FacilityPatientQuery(selectedPatient, facilityQueryFields));
    }

    private Patient getSelectedPatient(List<Patient> patientList) {
        System.out.println("Select patient id: ");
        Map<Integer, Patient> patientMap = new HashMap<>();
        Integer ids = 0;
        for (Patient patient : patientList) {
            System.out.println(" [ " + ids + " ] " + patient.getName() + " " + patient.getSurname() + " " + patient.getPesel() + " " + patient.getAddress());
            patientMap.put(ids, patient);
            ids++;
        }
        int selectedPatientId;

        while (true) {
            try {
                selectedPatientId = Menu.getConsoleNumberInput();
                if (patientMap.containsKey(selectedPatientId)) {
                    return patientMap.get(selectedPatientId);
                } else {
                    System.out.println("Wrong patient number selected. Try select again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong patient number selected. Try select again.");
            }
        }
    }
}