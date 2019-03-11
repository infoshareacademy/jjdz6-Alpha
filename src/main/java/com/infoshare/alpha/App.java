package com.infoshare.alpha;

import static com.infoshare.alpha.HealthFacility.deserializeHealthFacility;
import static com.infoshare.alpha.HealthFacility.serializeHealthFacility;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /*
        1. install maven in your system ( ubuntu : sudo apt install mvn )
        2. build project go to project dir where is pom.xml file, then : mvn install
        3. execute jar from target/ dir: java -jar childDevelopmentSupportSystem-0.1.jar
        */

        serializeHealthFacility();
        deserializeHealthFacility();

        Menu.menu();
        Menu.choiceOfMenuOption();
    }
}
