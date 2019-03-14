package com.infoshare.alpha.wwr.utils;

import java.util.Scanner;

public class Menu {

	public static String PATIENT_MENU = "p";
	public static String FACILITY_MENU = "f";
	public static String EXIT = "x";

    // klasa w ktorej beda zaimplementowane funkcje wyswietlajace :
    // 1. menu glowne
    // 2. submenu dla pacjentow
    // 3. submenu dla placowek
	
	
	public static void printMainMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("Main menu: ");
		System.out.println(" ( " + Menu.PATIENT_MENU + " ) Patient ");
		System.out.println(" ( " + Menu.FACILITY_MENU + " ) Facility ");
		System.out.println(" ( " + Menu.EXIT + " ) Program exit ");
		System.out.println("------------------------------------------------");
	}
	
	public static void printPatientMenu() {
		
		System.out.println("Patient menu: ");
		
		System.out.println("1. Show all patients");
		System.out.println("2. Find patient");
		
		System.out.println("3. Add patient");
		System.out.println("4. Edit patient");
		System.out.println("5. Delete patient");
		
		System.out.println("6. Add patiients from file");
	}

	public static void printFacilitiesMenu() {
		System.out.println("Facilities menu: ");
		
		System.out.println("1. Show all facilities");
		System.out.println("2. Find facility");
		
		System.out.println("3. Add facility");
		System.out.println("4. Edit facility");
		System.out.println("5. Delete facility");
		
		System.out.println("6. Add facilities from file");
		
	}
	
	public static Integer getConsoleNumberInput() {
	        Scanner scanner = new Scanner(System.in);
	        return scanner.nextInt();
	}
	
	public static String getConsoleStringInput(){
	        Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
	    }
}
