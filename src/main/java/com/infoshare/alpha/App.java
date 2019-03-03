package com.infoshare.alpha;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Pesel;
import com.infoshare.alpha.wwr.facilities.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.facilities.FacilitiesService;
import com.infoshare.alpha.wwr.facilities.Facility;
import com.infoshare.alpha.wwr.patients.*;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

       
		/*
        1. install maven in your system ( ubuntu : sudo apt install mvn )
        2. build project go to project dir where is pom.xml file, then : mvn install
        3. execute jar from target/ dir: java -jar childDevelopmentSupportSystem-0.1.jar
        */

//		testFacilityWrite();
//        testFacilitiesRepo();
//        testGetNearestFacilities();
//        testGetFacilitiesByQuery();


    }

    public static void testFacilityWrite() {
        FacilitiesService facilitiesService = new FacilitiesService();
        facilitiesService.add(new Facility("WWR-Gdynia-Port-2", new Address("Gdynia", "Portowa 2", "+48 112 234 111")));
        System.out.println("saved.");

        FacilitiesReadModelDbRepository facilitiesReadModelDbRepository = new FacilitiesReadModelDbRepository();

        facilitiesReadModelDbRepository.getAll().printAllFacilities();

    }

    public static void testFacilitiesRepo() {

        FacilitiesReadModelDbRepository facilitiesReadModelDbRepository = new FacilitiesReadModelDbRepository();
        facilitiesReadModelDbRepository.getAll().printAllFacilities();
    }

    public static void testGetFacilitiesByQuery() {

        PatientsFileReadModel patientFileReadModel = new PatientsFileReadModel(
                new FacilitiesReadModelDbRepository(),
                new PatientsRepository()
        );

        PatientFacilityQuery patientFacilityQuery = new PatientFacilityQuery(
                new Patient(
                        "Adam",
                        "Kowalski",
                        new Pesel("12121203123"),
                        new Address("Gdynia", "Nowe ogrody 23/12", "+48 123 123 123")
                ),
                PatientFacilityQueryFields.FACILITY_NAME,
                "WWR4"
        );

        List<Facility> facilities = patientFileReadModel.getPatientFacilitiesByQuery(patientFacilityQuery);

        for(Facility i : facilities) {
            System.out.println(i.toString());
        }

    }


    public static void testGetNearestFacilities()
    {
        PatientsFileReadModel patientFileReadModel = new PatientsFileReadModel(
                new FacilitiesReadModelDbRepository(),
                new PatientsRepository()
        );

        List<Facility> nextFacilities = patientFileReadModel.getNearestPatientFacilitiesByCity(
                new Patient(
                        "Adam",
                        "Kowalski",
                        new Pesel("12121203123"),
                        new Address("Gdynia", "Nowe ogrody 23/12", "+48 123 123 123")
                ));

        for(Facility i : nextFacilities) {
            System.out.println(i.toString());
        }

    }

}
