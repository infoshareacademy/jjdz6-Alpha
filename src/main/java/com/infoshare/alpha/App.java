package com.infoshare.alpha;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.di.AppDI;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.domain.patients.entity.Patient;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.domain.patients.readmodel.PatientsReadModelDbRepository;
import com.infoshare.alpha.wwr.utils.Menu;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    	String facilitiesRepoPath = "/Users/pkowerzanow/dev/jjdz6-Alpha/src/main/resources/facilities.json";
    	String patientsRepoPath = "/Users/pkowerzanow/dev/jjdz6-Alpha/src/main/resources/patients.json";
        // Te parametry beda przesylane z args.
        //String facilitiesRepoPath = "/home/pkowerzanow/dev/childDevelopmentSupportSystem/src/main/resources/facilities.json";
    	//String patientsRepoPath = "/home/piotr/dev/infoshare/jjdz6-Alpha/src/main/resources/patients.json";
    	
    	
    	App.initializeDi(facilitiesRepoPath, patientsRepoPath);
    	App.wwrPlay();

    	//exampleGetAllFacilities();
        //exampleGetPatientFacilitiesByQuery();
        //exampleGetFacilitiesByQuery();
    	//exampleGetAllPatients();
    }
    
    
    // ------- Func App -------------------------
    private static void wwrPlay() {
    	
    	// funkcja ktora ma za zadanie wysietlac menu , podmenu 
    	// zbierac informacje o wybranym menu oraz submenu oraz uruchamiac opcje systemu
    	
    	boolean programEnd = false;
    	String mainMenuOption = null;
    	
    	Menu.printMainMenu();
    	
    	while(!programEnd) {
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
    		}
    	}
    	System.out.println("Bye.");
    }
    
    private static void patientOption() {
    	boolean patientMenuEnd = false;
    	int patientMenuOption;
    	
    	Menu.printPatientMenu();
    	
    	while(!patientMenuEnd) {
    		patientMenuOption = Menu.getConsoleNumberInput();
    		
    		switch(patientMenuOption) {
    		case 1: 
    			System.out.println("Add patient.");
    			App.addPatient();
    			break;
    		case 2:
    			System.out.println("Edit patient");
    			break;
    		case 0:
    			patientMenuEnd = true;
    			break;
    		}
    	}
    }
    
    private static void facilityOption() {
    	boolean facilityMenuEnd = false;
    	
    	int facilityMenuOption;
    	
    	Menu.printFacilitiesMenu();
    	
    	while(!facilityMenuEnd) {
    		facilityMenuOption = Menu.getConsoleNumberInput();
    		switch(facilityMenuOption) {
    		case 1:
    			System.out.println("Add facility");
    			break;
    		case 2:
    			System.out.println("Edit facility");
    			break;
    		case 0:
    			facilityMenuEnd = true;
    			break;
    		}
    	}
    }
    
    
    private static void addPatient() {
    	// assemby patient data
    	System.out.println("Add patient: ");
    	System.out.println("Enter patient name: ");
    	String name = Menu.getConsoleStringInput();
    	
    	System.out.println("Enter patient surname: ");
    	String surname = Menu.getConsoleStringInput();
    	
    	
    	// build add command : 
    	
    	// use patient service from di 
    	// add patient 
    	
    	// print confirmation for user

    }
    
    private Address void assemblyAddressData() {
    	
    	
    	return new Address();
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
        FacilitiesReadModel facilitiesReadModel = getFacilitiesReadModel();

        List <FacilityQueryField> facilityQueryFields = new ArrayList<>();
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

}

