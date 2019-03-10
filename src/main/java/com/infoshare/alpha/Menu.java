package com.infoshare.alpha;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu {
    public Integer choice;

    public static void menu() {
        System.out.println();
        System.out.println("                            MENU                      ");
        System.out.println("     *   Please choose an adequate option:            *");
        System.out.println("     *************************************************");
        System.out.println("     1. Patient                                       ");
        System.out.println("     2. Health facility                               ");
        System.out.println();
        System.out.println("     Enter your selection: _                          ");
    }

    private int getConsoleInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public static void choiceOfMenuOption() {
        boolean exit = false;

        while (!exit) {
            Menu menu = new Menu();
            menu.choice = menu.getConsoleInput();
            System.out.println();
            switch (menu.choice) {
                case 1:
                    // wykona sie tu funkcja przenoszaca nas w sub-menu pacjenta
                    Patient.patientSubMenu();
                    break;
                case 2:
                    // wykona sie tu funkcja przenoszaca nas w sub-menu placowki (health facility)
                    HealthFacility.healthFacilitySubMenu();
                    break;
                default:
                    System.out.println("Error.");
                    System.out.println("Please try again and reeneter a number from the given list of MENU options: ");
                    menu();
            }
        }
    }
}

