package com.infoshare.alpha;

import static com.infoshare.alpha.wwr.utils.Menu.MainMenu.*;
import com.infoshare.alpha.wwr.utils.WwrController;

/**
 * This class is main entry for wwr program
 */
public class App {
    public static void main( String[] args ){

        mainMenu();
        choiceOfMenuOption();

        String facilitiesRepoPath = args[0];
    	String patientsRepoPath = args[1];

		WwrController controller = new WwrController(facilitiesRepoPath, patientsRepoPath);

		controller.wwrPlay();
    }
}