package com.infoshare.alpha;

import com.infoshare.alpha.wwr.utils.WwrController;

/**
 * This class is main entry for wwr program
 */
public class App {
    public static void main(String[] args) {
        String facilitiesRepoPath = args[0];
        String patientsRepoPath = args[1];

        WwrController controller = new WwrController(facilitiesRepoPath, patientsRepoPath);

        controller.wwrPlay();
    }
}

