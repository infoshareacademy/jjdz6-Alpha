package com.infoshare.alpha;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HealthFacility {

    private static final String HEALTH_FACILITIES_JSON_PATH = "scr/main/resources/HealthFacilities.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

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
        List<HealthFacility> healthFacilities = readListFromJsonFile(HEALTH_FACILITIES_JSON_PATH);
        for (HealthFacility healthFacility : healthFacilities) {
            System.out.println(GSON.toJson(healthFacility));
        }
    }

    public static void serializeHealthFacility() {
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

        //Dodanie osrodkow do listy i zapisanie listy do pliku json
        List<HealthFacility> healthFacilities = Arrays.asList(healthFacility1, healthFacility2, healthFacility3);
        saveListToJsonFile(healthFacilities, HEALTH_FACILITIES_JSON_PATH);
    }

    private static void saveListToJsonFile(List<HealthFacility> list, String path) {
        try (Writer writer = new FileWriter(path)) {
            GSON.toJson(list, writer);
            System.out.println("Saved to json file: " + path);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    private static List<HealthFacility> readListFromJsonFile(String path) {
        try (Reader reader = new FileReader(path)) {
            System.out.println("Reading from json file: " + path);
            Type listType = new TypeToken<ArrayList<HealthFacility>>() {
            }.getType();
            List<HealthFacility> collection = GSON.fromJson(reader, listType);
            System.out.println("List successfully uploaded. Number of elements: " + collection.size());
            return collection;
        } catch (IOException e) {
            System.out.println("File not found or broken: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
