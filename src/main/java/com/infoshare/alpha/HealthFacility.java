package com.infoshare.alpha;

import com.google.gson.Gson;

public class HealthFacility {

    private String name;
    private String street;
    private String city;
    private String postalCode;
    private String telephoneNumber;
    private boolean isPrivate;

    //new addition
    private Specialist specialist;

    public HealthFacility(String name, String street, String city, String postalCode, String telephoneNumber, boolean isPrivate, Specialist specialist) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.telephoneNumber = telephoneNumber;
        this.isPrivate = isPrivate;
        this.specialist = specialist;

    }

    public HealthFacility() {
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

    public static void deserializeHealthFacility() {
        String HealthFacility1 = "{'name': 'NZOZ Ośrodek Wczesnej Interwencji','street': 'Harcerska 4', 'city': 'Gdynia','postalCode': '81-425','telephoneNumber': '58 622-07-48','isPrivate': false, 'specialist':{ 'name':'Marta', 'lastName': 'Spych', 'specialization': 'neurologopeda'}";

        Gson gson1 = new Gson();
        HealthFacility healthFacility1 = gson1.fromJson(HealthFacility1, HealthFacility.class);

        String HealthFacility2 = "{'name': 'NZOZ Ośrodek Wczesnej Interwencji, filia nr 1','street': 'Necla 11', 'city': 'Gdynia','postalCode': '81-377','telephoneNumber': '58 621-74-40','isPrivate': false, 'specialist':{ 'name':'Joanna', 'lastName': 'Węglarz', 'specialization': 'psycholog'}";

        Gson gson2 = new Gson();
        HealthFacility healthFacility2 = gson2.fromJson(HealthFacility2, HealthFacility.class);

        String HealthFacility3 = "{'name': 'Ośrodek Wczesnej Interwencji i Wspomagania Rozwoju w Gdańsku','street': 'Jagiellońska 11', 'city': 'Gdańsk','postalCode': '80-371','telephoneNumber': '58 553-41-36','isPrivate': false, 'specialist':{ 'name':'Małgorzata', 'lastName': 'Jeszczerska', 'specialization': 'pedagog'}";

        Gson gson3 = new Gson();
        HealthFacility healthFacility3 = gson3.fromJson(HealthFacility3, HealthFacility.class);

    }

    public static void serializeSpecialistInHealthFacility() {
        Specialist specialist1 = new Specialist(
                "Marta",
                "Spych",
                "neurologopeda"
        );

        HealthFacility healthFacility1 = new HealthFacility(
                "NZOZ Ośrodek Wczesnej Interwencji",
                "Harcerska 4",
                "Gdynia",
                "81-425",
                "58 622-07-48",
                false,
                specialist1
        );

        String json1 = new Gson().toJson(healthFacility1);

        Specialist specialist2 = new Specialist(
                "Joanna",
                "Węglarz",
                "psycholog"
        );

        HealthFacility healthFacility2 = new HealthFacility(
                "NZOZ Ośrodek Wczesnej Interwencji, filia nr 1",
                "Necla 11",
                "Gdynia",
                "81-377",
                "58 621-74-40",
                false,
                specialist2
        );

        String json2 = new Gson().toJson(healthFacility2);

        Specialist specialist3 = new Specialist(
                "Małgorzata",
                "Jeszczerska",
                "pedagog"
        );

        HealthFacility healthFacility3 = new HealthFacility(
                "Ośrodek Wczesnej Interwencji i Wspomagania Rozwoju w Gdańsku",
                "Jagiellońska 11",
                "Gdańsk",
                "80-371",
                "58 553-41-36",
                false,
                specialist3
        );

        String json3 = new Gson().toJson(healthFacility3);
    }
}
