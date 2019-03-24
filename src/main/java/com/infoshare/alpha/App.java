package com.infoshare.alpha;

<<<<<<< HEAD
import static com.infoshare.alpha.HealthFacility.deserializeHealthFacility;
import static com.infoshare.alpha.HealthFacility.serializeSpecialistInHealthFacility;

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

        serializeSpecialistInHealthFacility();
        deserializeHealthFacility();

        Menu.menu();
        Menu.choiceOfMenuOption();
=======
import com.infoshare.alpha.wwr.utils.WwrController;

/**
 * This class is main entry for wwr program
 */
public class App 
{
    public static void main( String[] args )
    {
    	String facilitiesRepoPath = args[0];
    	String patientsRepoPath = args[1];

		WwrController controller = new WwrController(facilitiesRepoPath, patientsRepoPath);

		controller.wwrPlay();
>>>>>>> develop
    }
}

