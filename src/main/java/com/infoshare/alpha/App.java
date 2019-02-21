package com.infoshare.alpha;

import com.infoshare.alpha.wwr.Address;
import com.infoshare.alpha.wwr.Institution;
import com.infoshare.alpha.wwr.Patient;
import com.infoshare.alpha.wwr.Pesel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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


    }

    public static void filterTest()
    {
        Address address = new Address("Gdańsk", "Pilotów 23e", "+48 691 957 655");
        Pesel pesel = new Pesel("84101714434");
        Patient patient = new Patient("Jan", "Nowak", pesel , address );

        List<Institution> institutions = new ArrayList<Institution>();

        institutions.add(new Institution("WWR1", new Address("Gdańsk", "Nowe Ogroady 23", "+48 564 123 123")));
        institutions.add(new Institution("WWR2", new Address("Gdańsk", "Al. Gruwaldzka 223", "+48 564 123 555")));
        institutions.add(new Institution("WWR3", new Address("Sopot", "Zwyciestwa 17", "+48 754 123 123")));
        institutions.add(new Institution("WWR4", new Address("Gdynia", "Kolejowa 23", "+48 112 123 123")));
        institutions.add(new Institution("WWR5", new Address("Gdynia", "Swietojanska 110", "+48 456 123 123")));


        String filter = "Gdańsk";

        List<Institution> filteredInstitutions = institutions.stream().filter(s->filter.equals(s.getAddress().getCity())).collect(Collectors.toList());

        for (Institution i : filteredInstitutions) {
            System.out.println(i.toString());
        }
        //institutions.stream().filter(s->"Gdańsk".equals(s.getAddress().getCity())).findAny();


//        Optional<Institution> inst = institutions.stream().filter(i->"Gdańsk".equals(i.getAddress().getCity())).findAny();
//        System.out.println(inst.toString());
    }
}
