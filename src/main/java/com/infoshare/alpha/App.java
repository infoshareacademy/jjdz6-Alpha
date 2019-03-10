package com.infoshare.alpha;


import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 *
 */
public class App 
{
    public static void main( String[] args ) {
        /*
        1. install maven in your system ( ubuntu : sudo apt install mvn )
        2. build project go to project dir where is pom.xml file, then : mvn install
        3. execute jar from target/ dir: java -jar childDevelopmentSupportSystem-0.1.jar
        */

        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("facilities.json")));
        } catch (IOException e) {
        }
        HealthFacility[] healthFacilities = gson.fromJson(json, HealthFacility[].class);
        Menu.menu();
       Menu.choiceOfMenuOption();
    }
}
