package com.infoshare.alpha;

import com.google.gson.Gson;

public class HealthFacility {

    private String name;
    private String street;
    private String city;
    private String postalCode;
    private String telephoneNumber;
    private boolean isPrivate;


    public HealthFacility(String name, String street, String city, String postalCode, String telephoneNumber, boolean isPrivate) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.telephoneNumber = telephoneNumber;
        this.isPrivate = isPrivate;

    }

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

    public static void serializeHealthFacility() {
        HealthFacility healthFacility1 = new HealthFacility(
                "NZOZ Ośrodek Wczesnej Interwencji",
                "Harcerska 4",
                "Gdynia",
                "81-425",
                "58 622-07-48",
                false
        );

        Gson gson1 = new Gson();
        String json1 = gson1.toJson(healthFacility1);

        HealthFacility healthFacility2 = new HealthFacility(
                "NZOZ Ośrodek Wczesnej Interwencji, filia nr 1",
                "Necla 11",
                "Gdynia",
                "81-377",
                "58 621-74-40",
                false
        );

        Gson gson2 = new Gson();
        String json2 = gson2.toJson(healthFacility2);

        HealthFacility healthFacility3 = new HealthFacility(
                "Ośrodek Wczesnej Interwencji i Wspomagania Rozwoju w Gdańsku",
                "Jagiellońska 11",
                "Gdańsk",
                "80-371",
                "58 553-41-36",
                false
        );

        Gson gson3 = new Gson();
        String json3 = gson3.toJson(healthFacility3);
    }
    public static void deserializeHealthFacility() {
        String userJson1 = "{'name': 'NZOZ Ośrodek Wczesnej Interwencji','street': 'Harcerska 4', 'city': 'Gdynia','postalCode': '81-425','telephoneNumber': '58 622-07-48','isPrivate': false}";

        Gson gson1 = new Gson();
        HealthFacility healthFacility1 = gson1.fromJson(userJson1, HealthFacility.class);

        String userJson2 = "{'name': 'NZOZ Ośrodek Wczesnej Interwencji, filia nr 1','street': 'Necla 11', 'city': 'Gdynia','postalCode': '81-377','telephoneNumber': '58 621-74-40','isPrivate': false}";

        Gson gson2 = new Gson();
        HealthFacility healthFacility2 = gson2.fromJson(userJson2, HealthFacility.class);

        String userJson3 = "{'name': 'Ośrodek Wczesnej Interwencji i Wspomagania Rozwoju w Gdańsku','street': 'Jagiellońska 11', 'city': 'Gdańsk','postalCode': '80-371','telephoneNumber': '58 553-41-36','isPrivate': false}";

        Gson gson3 = new Gson();
        HealthFacility healthFacility3 = gson3.fromJson(userJson3, HealthFacility.class);
        
    }

}
