package com.infoshare.alpha;

import com.infoshare.alpha.wwr.di.AppDI;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.facilities.readModel.FacilitiesReadModel;

//import com.infoshare.alpha.wwr.facilities.FacilitiesService;

public class App 
{
    public static AppDI di;
    public static void initializeDi(String facilitiesFilePath, String patientsFilePath) {
        App.di = new AppDI(facilitiesFilePath, patientsFilePath);
    }

    public static void main( String[] args )
    {
    		String facilitiesRepoPath = "/home/piotr/dev/infoshare/jjdz6-Alpha/src/main/resources/facilities.json";
    		String patientsRepoFilePath = "/home/piotr/dev/infoshare/jjdz6-Alpha/src/main/resources/patients.json";

    		App.initializeDi(facilitiesRepoPath, patientsRepoFilePath);


    		FacilitiesReadModel facilitiesReadModel = (FacilitiesReadModel) di.getService(FacilitiesReadModel.class.toString());
    		
    		Facilities facilities = facilitiesReadModel.getAll();
    		facilities.printAllFacilities();

       
		/*
        1. install maven in your system ( ubuntu : sudo apt install mvn )
        2. build project go to project dir where is pom.xml file, then : mvn install
        3. execute jar from target/ dir: java -jar childDevelopmentSupportSystem-0.1.jar
        */

    }





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
