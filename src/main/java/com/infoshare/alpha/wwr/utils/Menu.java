package com.infoshare.alpha.wwr.utils;

import java.util.Scanner;

public class Menu {
    
    public Integer choice;

    public static void printMainMenu() {


        System.out.println();
        System.out.println("                          MAIN MENU                     ");
        System.out.println("     *       Please choose an adequate option:         *");
        System.out.println("     ***************************************************");
        System.out.println("     1. Patient menu                                    ");
        System.out.println("     2. Facility menu                                   ");
        System.out.println("     3. Exit program                                    ");
    }

    public static void printPatientMenu() {
        System.out.println();
        System.out.println("                       Patient MENU                   ");
        System.out.println("     *       Please choose an adequate option:       *");
        System.out.println("     *************************************************");
        System.out.println("     1. Show all patients                             ");
        System.out.println("     2. Find patient                                  ");
        System.out.println("     3. Find patients facilities                      ");
        System.out.println();
        System.out.println("     4. Add patient                                   ");
        System.out.println("     5. Edit patient                                  ");
        System.out.println("     6. Delete patient                                ");
        System.out.println("     7. Add patients from file                        ");
        System.out.println("     0. -> EXIT TO MAIN MENU                          ");
    }

    public static void printFacilitiesMenu() {
        System.out.println();
        System.out.println("                       Facilities menu                ");
        System.out.println("     *       Please choose an adequate option:       *");
        System.out.println("     *************************************************");
        System.out.println("     1. Show all facilities                           ");
        System.out.println("     2. Find facility                                 ");
        System.out.println();
        System.out.println("     3. Add facility                                  ");
        System.out.println("     4. Edit facility                                 ");
        System.out.println("     5. Delete facility                               ");
        System.out.println();
        System.out.println("     6. Add facilities from file                      ");
        System.out.println("     0. -> EXIT TO MAIN MENU                          ");
    }

    public static Integer getConsoleNumberInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getConsoleStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
        }
    }

    public static void shouldContinue() {
        boolean endContinue = false;
        while (!endContinue) {
            System.out.println("Press c to continue ...");
            String c = Menu.getConsoleStringInput();
            if (c.equals("c")) {
                endContinue = true;
            }
        }
    }

    public static void choiceOfMenuOption() {
        boolean exit = false;

        while (!exit) {
            Menu menu = new Menu();
            menu.choice = menu.getConsoleNumberInput();
            System.out.println();
            switch (menu.choice) {
                case 1:
                    printPatientMenu();
                case 2:
                    printFacilitiesMenu();
                    break;
                case 3:
                    clearConsole();
                    break;
                default:
                    System.out.println("Error.");
                    System.out.println("Please try again and reeneter a number from the given list of MENU options: ");
                    printMainMenu();
            }
        }
    }
}

