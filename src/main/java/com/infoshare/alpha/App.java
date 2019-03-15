package com.infoshare.alpha;

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
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModel;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.patients.repository.PatientsRepository;
import com.infoshare.alpha.wwr.utils.InputForms;
import com.infoshare.alpha.wwr.utils.Menu;

import java.util.*;

/**
 * This class is controller for wwr program
 */
public class App 
{
    private static AppDI di;
    
    private static void initializeDi(String facilitiesFilePath, String patientsFilePath) {
        App.di = new AppDI(facilitiesFilePath, patientsFilePath);
    }

    public static void main( String[] args )
    {
    	// Te parametry beda przesylane z args.
//    	String facilitiesRepoPath = "/Users/pkowerzanow/dev/jjdz6-Alpha/src/main/resources/facilities.json";
//    	String patientsRepoPath = "/Users/pkowerzanow/dev/jjdz6-Alpha/src/main/resources/patients.json";

        String facilitiesRepoPath = "/home/piotr/dev/infoshare/jjdz6-Alpha/src/main/resources/facilities.json";
    	String patientsRepoPath = "/home/piotr/dev/infoshare/jjdz6-Alpha/src/main/resources/patients.json";
    	
    	
    	App.initializeDi(facilitiesRepoPath, patientsRepoPath);
    	App.wwrPlay();

    }

    // ------- Func App -------------------------
    private static void wwrPlay() {
    	boolean programEnd = false;
    	String mainMenuOption;
    	
    	Menu.printMainMenu();
    	
    	while(!programEnd) {
    		try {
				Menu.clearConsole();
				mainMenuOption = Menu.getConsoleStringInput();
				switch (mainMenuOption) {
					case "p":
						App.patientOption();
						Menu.clearConsole();
						Menu.printMainMenu();
						break;
					case "f":
						App.facilityOption();
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
    
    private static void patientOption() {
    	boolean patientMenuEnd = false;
    	int patientMenuOption;

    	Menu.printPatientMenu();

    	while(!patientMenuEnd) {
    		try {
				Menu.clearConsole();
				patientMenuOption = Menu.getConsoleNumberInput();

				switch(patientMenuOption) {
					case 1:
						App.showAllPatients();
						Menu.clearConsole();
						Menu.printPatientMenu();
						break;
					case 3:
						System.out.println("Add patient.");
						App.addPatient();
						Menu.clearConsole();
						Menu.printPatientMenu();
						break;
					case 4:
						System.out.println("Edit patient");
						Menu.clearConsole();
						Menu.printPatientMenu();
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
    
    private static void facilityOption() {
    	boolean facilityMenuEnd = false;
    	int facilityMenuOption;

		Menu.printFacilitiesMenu();

    	while(!facilityMenuEnd) {
    		try {
				facilityMenuOption = Menu.getConsoleNumberInput();
				switch(facilityMenuOption) {
					case 1:
						System.out.println("Show all facilities:");
						showAllFacilities();
						Menu.printFacilitiesMenu();
						break;
					case 3:
						System.out.println("Add facility");
						Menu.printFacilitiesMenu();
						break;
					case 4:
						System.out.println("Edit facility");
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

    private static void addPatient() {
    	try {
			Patient patient = InputForms.getPatientFromKeyboard();
			PatientsService patientsService = (PatientsService) di.getService(PatientsService.class.getName());
			patientsService.add(patient);

		} catch (PeselException e) {
			System.out.println("Pesel number is invalid.");
		}
    }

    private static void showAllPatients() {
		PatientsReadModel patientsReadModel = (PatientsReadModel) di.getService(PatientsReadModel.class.getName());
		System.out.println("---------------Patients in system--------------------------");
		patientsReadModel.getAll().printAllPatients();
		System.out.println("-----------------------------------------------------------");
	}

	private static void showAllFacilities() {

    	FacilitiesReadModel facilitiesReadModel = (FacilitiesReadModel) di.getService(FacilitiesReadModel.class.getName());
		System.out.println("-------------All facilities in system-------------------------------------------------");
    	facilitiesReadModel.getAll().printAllFacilities();
		System.out.println("--------------------------------------------------------------------------------------");

	}
    
    
    // ------- DI usage examples -----------------
    
         
    private static FacilitiesReadModel getFacilitiesReadModel() {
    	
    	return (FacilitiesReadModel) di.getService(FacilitiesReadModel.class.toString());
    }

    public static void exampleGetAllPatients() {
    	PatientsReadModelDbRepository patientsReadModelDbRepository = (PatientsReadModelDbRepository) di.getService(PatientsReadModelDbRepository.class.toString());
    
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

}

