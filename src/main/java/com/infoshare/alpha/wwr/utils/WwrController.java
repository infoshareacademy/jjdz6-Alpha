package com.infoshare.alpha.wwr.utils;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityAddCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityDeleteCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityEditCommand;
import com.infoshare.alpha.wwr.common.Facilities;
import com.infoshare.alpha.wwr.common.Facility;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.patients.PatientsService;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDbRepository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class WwrController {

    @Inject
    private PatientsService patientsService;
    @Inject
    private PatientsReadModelDbRepository patientsReadModelDb;
    @Inject
    private FacilitiesService facilitiesService;
    @Inject
    private FacilitiesReadModelDbRepository facilitiesReadModelDb;

    public void wwrPlay() {
        boolean programEnd = false;
        String mainMenuOption;

        Menu.printMainMenu();

        while (!programEnd) {
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

        while (!patientMenuEnd) {
            try {
                Menu.clearConsole();
                patientMenuOption = Menu.getConsoleNumberInput();

                switch (patientMenuOption) {
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

        while (!facilityMenuEnd) {
            try {
                facilityMenuOption = Menu.getConsoleNumberInput();
                switch (facilityMenuOption) {
                    case 1:
                        System.out.println("Show all facilities:");
                        this.showAllFacilities();
                        Menu.shouldContinue();
                        Menu.printFacilitiesMenu();
                        break;
                    case 3:
                        this.addFacility();
                        Menu.shouldContinue();
                        Menu.printFacilitiesMenu();
                        break;
                    case 4:
                        this.editFacility();
                        Menu.shouldContinue();
                        Menu.printFacilitiesMenu();
                        break;
                    case 5:
                        this.deleteFacility();
                        Menu.shouldContinue();
                        Menu.printFacilitiesMenu();
                        break;
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
            patientsService.add(patient);

        } catch (PeselException e) {
            System.out.println("Pesel number is invalid.");
        }
    }

    private void showAllPatients() {
        System.out.println("---------------Patients in system--------------------------");
        patientsReadModelDb.getAll().printAllPatients();
        System.out.println("-----------------------------------------------------------");
    }

    private void showAllFacilities() {
        System.out.println("-------------All facilities in system-------------------------------------------------");
        facilitiesReadModelDb.getAll().printAllFacilities();
        System.out.println("--------------------------------------------------------------------------------------");

    }

    private void findPatientsFacilities() {
        PatientsFacilitiesController controller =
                new PatientsFacilitiesController();
        controller.findPatientsFacilities();
    }

    public void addFacility() {
        try {
            Facility newFacility = InputForms.getFacilityFromKeyboard();
            facilitiesService.add(newFacility);
            System.out.println("Facility " + newFacility.getName() + " has been added to the database" + "\n");
        } catch (FacilitiesException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void deleteFacility() {
        try {
            Facility facilityToBeDeleted = chooseFacilityFromList();
            facilitiesService.delete(facilityToBeDeleted);
            System.out.println("Facility " + facilityToBeDeleted.getName() + " has been deleted from the database" + "\n");
        } catch (FacilitiesException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void editFacility() {
        try {
            Facility oldFacility = chooseFacilityFromList();
            System.out.println("Edit facility's " + oldFacility.getName() + " details");
            Facility editedFacility = InputForms.getEditedFacilityFromKeyboard(oldFacility);
            facilitiesService.edit(oldFacility, editedFacility);
            System.out.println("Facility's detail change has been saved" + "\n");
        } catch (FacilitiesException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public Facility chooseFacilityFromList() {
        Facilities facilities = facilitiesReadModelDb.getAll();
        List<Facility> facilityList = facilities.getFacilities();
        System.out.println("Select facility id: ");
        Map<Integer, Facility> searchById = new HashMap<>();
        Integer ids = 1;
        for (Facility facility : facilityList) {
            Address facilityAddress = facility.getAddress();
            System.out.println(" [ " + ids + " ] " + facility.getName() + " " + facilityAddress.getCity() + " " + facilityAddress.getStreet() + " " + facilityAddress.getPhone());
            searchById.put(ids, facility);
            ids++;
        }
        Integer selectFacilityId = null;
        do {
            try {
                selectFacilityId = Menu.getConsoleNumberInput();
                if (!searchById.containsKey(selectFacilityId)) {
                    System.out.println("Select one of the id's above:");
                    selectFacilityId = null;
                }
            } catch (InputMismatchException e) {
                System.out.println("Select one of the id's above:");
            }
        } while (selectFacilityId == null);
        return searchById.get(selectFacilityId);
    }
}
