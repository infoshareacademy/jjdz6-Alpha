package com.infoshare.alpha;


import com.infoshare.alpha.wwr.*;

import java.util.List;


/**
 * Hello world!
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
		/*
        1. install maven in your system ( ubuntu : sudo apt install mvn )
        2. build project go to project dir where is pom.xml file, then : mvn install
        3. execute jar from target/ dir: java -jar childDevelopmentSupportSystem-0.1.jar
        */


        testGetNearestFacilities();


    }

    public static void testGetFacilitiesByQuery() {

    }


    public static void testGetNearestFacilities()
    {
        PatientsFileReadModel patientFileReadModel = new PatientsFileReadModel(
                new FacilitiesRepository(),
                new PatientsRepository()
        );

        List<Facility> nextInstitutions = patientFileReadModel.getNearestPatientFacilitiesByCity(
                new Patient(
                        "Adam",
                        "Kowalski",
                        new Pesel("12121203123"),
                        new Address("Gdynia", "Nowe ogrody 23/12", "+48 123 123 123")
                ));

        for(Facility i : nextInstitutions) {
            System.out.println(i.toString());
        }

    }





//    public static void filterTest()
//    {
//        Address address = new Address("Gdańsk", "Pilotów 23e", "+48 691 957 655");
//        Pesel pesel = new Pesel("84101714434");
//        Patient patient = new Patient("Jan", "Nowak", pesel , address );
//
//        List<Facility> institutions = new ArrayList<Facility>();
//
//        institutions.add(new Facility("WWR1", new Address("Gdańsk", "Nowe Ogroady 23", "+48 564 123 123")));
//        institutions.add(new Facility("WWR2", new Address("Gdańsk", "Al. Gruwaldzka 223", "+48 564 123 555")));
//        institutions.add(new Facility("WWR3", new Address("Sopot", "Zwyciestwa 17", "+48 754 123 123")));
//        institutions.add(new Facility("WWR4", new Address("Gdynia", "Kolejowa 23", "+48 112 123 123")));
//        institutions.add(new Facility("WWR5", new Address("Gdynia", "Swietojanska 110", "+48 456 123 123")));
//
//
//        String filter = "Gdańsk";
//
//        List<Facility> filteredInstitutions = institutions.stream().filter(s->filter.equals(s.getAddress().getCity())).collect(Collectors.toList());
//
//        for (Facility i : filteredInstitutions) {
//            System.out.println(i.toString());
//        }
        //institutions.stream().filter(s->"Gdańsk".equals(s.getAddress().getCity())).findAny();


//        Optional<Facility> inst = institutions.stream().filter(i->"Gdańsk".equals(i.getAddress().getCity())).findAny();
//        System.out.println(inst.toString());
//    }
}
