package com.infoshare.alpha;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.di.AppDI;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.facilities.entity.Facility;
import com.infoshare.alpha.wwr.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.patients.entity.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is controller for wwr program
 */
public class App 
{
    public static AppDI di;
    public static void initializeDi(String facilitiesFilePath, String patientsFilePath) {
        App.di = new AppDI(facilitiesFilePath, patientsFilePath);
    }
    
    

    public static void main( String[] args )
    {
    		//String facilitiesRepoPath = "/Users/pkowerzanow/dev/jjdz6-Alpha/src/main/resources/facilities.json";

        String facilitiesRepoPath = "/home/pkowerzanow/dev/childDevelopmentSupportSystem/src/main/resources/facilities.json";
    		String patientsRepoFilePath = "/home/piotr/dev/infoshare/jjdz6-Alpha/src/main/resources/patients.json";
    		App.initializeDi(facilitiesRepoPath, patientsRepoFilePath);  
    		
    	//exampleGetAllFacilities();

        exampleGetPatientFacilitiesByQuery();

    }
     
    private static FacilitiesReadModel getFacilitiesReadModel() {
    	
    	return (FacilitiesReadModel) di.getService(FacilitiesReadModel.class.toString());
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
        facilityQueryFields.add(FacilityQueryField.FACILITY_NAME);

        FacilityPatientQuery facilityPatientQuery = new FacilityPatientQuery(
                new Patient("Adam", "Kowalski", new Pesel("87101812435"), new Address("Gdańsk", "ul.Pilotów 23", "+48 123 345 334")),
                facilityQueryFields
        );

        List<Facility> facilities = facilitiesReadModel.getByPatientCity(facilityPatientQuery);
        Facilities f = new Facilities();
        f.setFacilities(facilities);
        f.printAllFacilities();
    }
 
    
    
    
    
//    public static void generateUUIDS() {
//    	for(int i = 0; i < 8; i++) {
//    		System.out.println(UUID.randomUUID());
//    	}  	
//    }

//    public static void testGetFacilitiesByQuery() {
//
//        PatientsFileReadModel patientFileReadModel = new PatientsFileReadModel(
//                new FacilitiesReadModelDbRepository(),
//                new PatientsRepository()
//        );
//
//        PatientFacilityQuery patientFacilityQuery = new PatientFacilityQuery(
//                new Patient(
//                        "Adam",
//                        "Kowalski",
//                        new Pesel("12121203123"),
//                        new Address("Gdynia", "Nowe ogrody 23/12", "+48 123 123 123")
//                ),
//                PatientFacilityQueryFields.FACILITY_NAME,
//                "WWR4"
//        );
//
//        List<Facility> facilities = patientFileReadModel.getPatientFacilitiesByQuery(patientFacilityQuery);
//
//        for(Facility i : facilities) {
//            System.out.println(i.toString());
//        }

//    }


//    public static void testGetNearestFacilities()
//    {
//        PatientsFileReadModel patientFileReadModel = new PatientsFileReadModel(
//                new FacilitiesReadModelDbRepository(),
//                new PatientsRepository()
//        );
//
//        List<Facility> nextFacilities = patientFileReadModel.getNearestPatientFacilitiesByCity(
//                new Patient(
//                        "Adam",
//                        "Kowalski",
//                        new Pesel("12121203123"),
//                        new Address("Gdynia", "Nowe ogrody 23/12", "+48 123 123 123")
//                ));
//
//        for(Facility i : nextFacilities) {
//            System.out.println(i.toString());
//        }
//
//    }

}

