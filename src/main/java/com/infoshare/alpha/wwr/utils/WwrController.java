package com.infoshare.alpha.wwr.utils;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.common.PeselException;
import com.infoshare.alpha.wwr.di.AppDI;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
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
        PatientsFacilitiesController controller =
                new PatientsFacilitiesController(
                        (FacilitiesReadModel) di.getService(FacilitiesReadModel.class.getName()),
                        (PatientsReadModel) di.getService(PatientsReadModel.class.getName())
                );
        controller.findPatientsFacilities();
    }

}
