package com.infoshare.alpha.wwr.utils;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.di.AppDI;
import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityDeleteCommand;
import com.infoshare.alpha.wwr.domain.facilities.common.FacilitiesException;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesRepository;
import com.infoshare.alpha.wwr.domain.patients.PatientsService;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.query.PatientQuery;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModel;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.patients.repository.PatientsRepository;
import java.util.*;

public class WwrController {

    private static AppDI di;

    public WwrController(String facilitiesRepoPath, String patientsRepoPath) {
        this.di = new AppDI(facilitiesRepoPath, patientsRepoPath);
    }

    public void wwrPlay() {
        boolean programEnd = false;
        String mainMenuOption;

        Menu.printMainMenu();

        while(!programEnd) {
            try {
                Menu.clearConsole();
                mainMenuOption = Menu.getConsoleStringInput();
                switch (mainMenuOption) {
                    case "p":
                        this.patientOption();
                        Menu.clearConsole();
                        Menu.printMainMenu();
                        break;
                    case "f":
                        this.facilityOption();
                        Menu.clearConsole();
                        Menu.printMainMenu();
                        break;
                    case "x":
                        programEnd = true;
                        break;
                    default:
                        System.out.println("<<Option not implemented>>");
                }
            } catch (InputMismatchException e) {
                System.out.println("Selected option invalid. Select number option.");
            }
        }
        System.out.println("Bye.");
    }

    private void patientOption() {
        boolean patientMenuEnd = false;
        int patientMenuOption;

        Menu.printPatientMenu();

        while(!patientMenuEnd) {
            try {
                Menu.clearConsole();
                patientMenuOption = Menu.getConsoleNumberInput();

                switch(patientMenuOption) {
                    case 1:
                        this.showAllPatients();
                        Menu.shouldContinue();
                        Menu.clearConsole();
                        Menu.printPatientMenu();
                        break;
                    case 3:
                        this.findPatientsFacilities();
                        Menu.shouldContinue();
                        Menu.clearConsole();
                        Menu.printPatientMenu();
                        break;
                    case 4:
                        System.out.println("Add patient. -> not implemented yet");
                        this.addPatient();
                        Menu.shouldContinue();
                        Menu.clearConsole();
                        Menu.printPatientMenu();
                        break;
                    case 5:
                        System.out.println("Edit patient -> not implemented yet");
                        Menu.clearConsole();
                        Menu.printPatientMenu();
                        Menu.shouldContinue();
                        break;
                    case 0:
                        patientMenuEnd = true;
                        break;
                    default:
                        System.out.println("<<Option not implemented.exit>>");
                        patientMenuEnd = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selected option invalid. Select number option.");
            }
        }
    }

    private void facilityOption() {
        boolean facilityMenuEnd = false;
        int facilityMenuOption;

        Menu.printFacilitiesMenu();

        while(!facilityMenuEnd) {
            try {
                facilityMenuOption = Menu.getConsoleNumberInput();
                switch(facilityMenuOption) {
                    case 1:
                        System.out.println("Show all facilities:");
                        this.showAllFacilities();
                        Menu.shouldContinue();
                        Menu.printFacilitiesMenu();
                        break;
                    case 3:
                        System.out.println("Add facility -> not implement yet");
                        Menu.printFacilitiesMenu();
                        break;
                    case 4:
                        System.out.println("Edit facility -> not implemented yet");
                        Menu.printFacilitiesMenu();
                        break;
                    case 5:
                        System.out.println("Delete facility");
                        this.exampleGetAllFacilities();
                        this.deleteFacility();
                    case 0:
                        facilityMenuEnd = true;
                        break;
                    default:
                        System.out.println("<<Option not implemented.exit>>");
                        facilityMenuEnd = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Selected option invalid. Select number option.");
            }


        }
    }

    private void addPatient() {
        try {
            Patient patient = InputForms.getPatientFromKeyboard();
            PatientsService patientsService = (PatientsService) di.getService(PatientsService.class.getName());
            patientsService.add(patient);

        } catch (PeselException e) {
            System.out.println("Pesel number is invalid.");
        }
    }

    private void showAllPatients() {
        PatientsReadModel patientsReadModel = (PatientsReadModel) di.getService(PatientsReadModel.class.getName());
        System.out.println("---------------Patients in system--------------------------");
        patientsReadModel.getAll().printAllPatients();
        System.out.println("-----------------------------------------------------------");
    }

    private void showAllFacilities() {

        FacilitiesReadModel facilitiesReadModel = (FacilitiesReadModel) di.getService(FacilitiesReadModel.class.getName());
        System.out.println("-------------All facilities in system-------------------------------------------------");
        facilitiesReadModel.getAll().printAllFacilities();
        System.out.println("--------------------------------------------------------------------------------------");

    }

    private void findPatientsFacilities() {
        PatientsReadModel patientsReadModel = (PatientsReadModel) di.getService(PatientsReadModel.class.getName());
        FacilitiesReadModel facilitiesReadModel = (FacilitiesReadModel) di.getService(FacilitiesReadModel.class.getName());

        Patients patients = patientsReadModel.getAll();
        List<Patient> patientList = patients.getPatients();

        System.out.println("Select patient id: ");
        Map<Integer, Patient> patientMap = new HashMap<>();
        Integer ids = 0;
        for(Patient patient : patientList) {
            System.out.println(" [ " + ids + " ] " + patient.getName() + " " + patient.getSurname() + " " + patient.getPesel() + " " + patient.getAddress());
            patientMap.put(ids, patient);
            ids++;
        }

        int selectedPatientId = Menu.getConsoleNumberInput();
        Patient selectedPatient = patientMap.get(selectedPatientId);

        List<FacilityQueryField> facilityQueryFields = new ArrayList<>();
        facilityQueryFields.add(FacilityQueryField.CITY);
        List <Facility> facilities = facilitiesReadModel.getByPatient(new FacilityPatientQuery(selectedPatient, facilityQueryFields));


        System.out.println("-------------------------------------------------");
        System.out.println("Patients nearest facilities");
        System.out.println("-------------------------------------------------");
        if (facilities.size() > 0) {
            for (Facility facility : facilities) {
                System.out.println(facility);
            }
        } else {
            System.out.println("[!] [ No facilities found. ]");
        }

        System.out.println("-------------------------------------------------");
    }

    // ------- DI usage examples -----------------

    private static FacilitiesReadModel getFacilitiesReadModel() {

        return (FacilitiesReadModel) di.getService(FacilitiesReadModel.class.getName());
    }

    public static void exampleGetAllPatients() {
        PatientsReadModelDbRepository patientsReadModelDbRepository = (PatientsReadModelDbRepository) di.getService(PatientsReadModelDbRepository.class.getName());

        Patients patients = patientsReadModelDbRepository.getAll();
        patients.printAllPatients();
    }

    public static void exampleGetAllFacilities() {
        FacilitiesReadModel facilitiesReadModel = getFacilitiesReadModel();
        Facilities facilities = facilitiesReadModel.getAll();
        facilities.printAllFacilities();
    }

    public static void exampleGetPatientFacilitiesByQuery() {
        try {
            FacilitiesReadModel facilitiesReadModel = getFacilitiesReadModel();

            List<FacilityQueryField> facilityQueryFields = new ArrayList<>();
            facilityQueryFields.add(FacilityQueryField.CITY);
//        facilityQueryFields.add(FacilityQueryField.STREET);

            FacilityPatientQuery facilityPatientQuery = new FacilityPatientQuery(
                    new Patient("Adam", "Kowalski", new Pesel("87101812435"), new Address("Gdynia", "Kolejowa 23", "+48 123 345 334")),
                    facilityQueryFields
            );

            List<Facility> facilities = facilitiesReadModel.getByPatient(facilityPatientQuery);
            Facilities f = new Facilities();
            f.setFacilities(facilities);
            f.printAllFacilities();
        } catch (PeselException e) {
            System.out.println("Pesel number is invalid");
        }
    }

    public static void exampleGetFacilitiesByQuery() {
        FacilitiesReadModel facilitiesReadModel = getFacilitiesReadModel();

        Map<FacilityQueryField, String> searchBy = new HashMap<FacilityQueryField, String>();
        searchBy.put(FacilityQueryField.CITY, "Gdańsk");
        FacilityQuery facilityQuery = new FacilityQuery(searchBy);

        List<Facility> facilities = facilitiesReadModel.getByQuery(facilityQuery);
        Facilities f = new Facilities();
        f.setFacilities(facilities);
        f.printAllFacilities();
    }

    public static void exampleAddPatients() throws PeselException {
        Patient patient = new Patient(
                "Jan",
                "Kowalski",
                new Pesel("84101713234"),
                new Address("Gdańsk", "Pilotów 23e", "345 33 333")
        );

        Patient patient2 = new Patient(
                "Jan",
                "Kowalski",
                new Pesel("84101713234"),
                new Address("Gdańsk", "Pilotów 23e", "345 33 333")
        );

        Patients patients = new Patients();
        patients.add(patient);
        patients.add(patient2);

        PatientsRepository patientsDbRepository = (PatientsRepository) di.getService(PatientsRepository.class.getName());

        patientsDbRepository.persist(patients);

    }

    public void deleteFacility() {
        FacilitiesReadModel facilitiesReadModel = getFacilitiesReadModel();
        System.out.println("Enter facility name:");
        String facilityName = Menu.getConsoleStringInput();
        for(Facility facility : facilitiesReadModel.getAll().getFacilities()) {
            if (facility.getName().equals(facilityName)) {
                FacilitiesService facilitiesService = (FacilitiesService) di.getService(FacilitiesService.class.getName());
                try {
                    facilitiesService.delete(new FacilityDeleteCommand(facility));
                } catch (FacilitiesException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
