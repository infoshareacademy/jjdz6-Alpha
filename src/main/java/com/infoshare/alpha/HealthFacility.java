package com.infoshare.alpha;

public class HealthFacility {

    public String name;
    public String street;
    public String city;
    public String postalCode;
    public String telephoneNumber;
    public boolean isPrivate;


    public static void healthFacilitySubMenu() {
        System.out.println();
        System.out.println("                   HEALTH FACILITY subMENU             ");
        System.out.println("     *   Please choose an adequate option:            *");
        System.out.println("     **************************************************");
        System.out.println("     1. Find the nearest patient's health facility     ");
        System.out.println("     2. Enter health facility's information            ");
        System.out.println("     3. Edit health facility's information             ");

        System.out.println();
        System.out.println("     Enter your selection: _                            ");
    }
}
