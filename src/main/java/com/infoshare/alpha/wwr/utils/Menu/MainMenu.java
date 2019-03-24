package com.infoshare.alpha.wwr.utils.Menu;

import java.util.Scanner;

import static com.infoshare.alpha.wwr.utils.Menu.HealthFacilitySubMenu.healthFacilitySubMenu;
import static com.infoshare.alpha.wwr.utils.Menu.PatientSubMenu.patientSubMenu;

public class MainMenu {

    public Integer choice;

    public static void mainMenu() {
        System.out.println();
        System.out.println("                            MENU                      ");
        System.out.println("     *   Please choose an adequate option:           *");
        System.out.println("     *************************************************");
        System.out.println("     1. PatientSubMenu                                ");
        System.out.println("     2. Health facility                               ");
        System.out.println();
        System.out.println("     Enter your selection: _                          ");
    }

    public int getConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void choiceOfMenuOption() {
        boolean exit = false;

        while (!exit) {
            MainMenu menu = new MainMenu();
            menu.choice = menu.getConsoleInput();
            System.out.println();
            switch (menu.choice) {
                case 1:
                    patientSubMenu();
                    break;
                case 2:
                    healthFacilitySubMenu();
                    break;
                default:
                    System.out.println("Error.");
                    System.out.println("Please try again and reeneter a number from the given list of MENU options: ");
                    mainMenu();
            }
        }
    }
}