package com.infoshare.alpha.wwr.domain.facilities.datastorage;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.entity.Specialist;

public class FacilitiesJsonStorage implements DI {

    private static final String HEALTH_FACILITIES_JSON_PATH = new File("facilities.json").getAbsolutePath();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void deserializeFacility() {
        List<Facility> facilities = readListFromJsonFile(HEALTH_FACILITIES_JSON_PATH);
        for (Facility facility : facilities) {
            System.out.println(GSON.toJson(facility));
        }
    }

    public static void serializeFacility() {
        Specialist specialist1 = new Specialist(
                "Marta",
                "Spych",
                "neurologopeda"
        );

        Facility facility1 = new Facility(
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

        Facility facility2 = new Facility(
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

        Facility facility3 = new Facility(
                "Ośrodek Wczesnej Interwencji i Wspomagania Rozwoju w Gdańsku",
                "Jagiellońska 11",
                "Gdańsk",
                "80-371",
                "58 553-41-36",
                false,
                specialist3
        );

        List<Facility> facilities = Arrays.asList(facility1, facility2, facility3);
        saveListToJsonFile(facilities, HEALTH_FACILITIES_JSON_PATH);
    }

    private static void saveListToJsonFile(List<Facility> list, String path) {
        try (Writer writer = new FileWriter(path)) {
            GSON.toJson(list, writer);
            System.out.println("Saved to json file: " + path);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    private static List<Facility> readListFromJsonFile(String path) {
        try (Reader reader = new FileReader(path)) {
            System.out.println("Reading from json file: " + path);
            Type listType = new TypeToken<ArrayList<Facility>>() {
            }.getType();
            List<Facility> collection = GSON.fromJson(reader, listType);
            System.out.println("List successfully uploaded. Number of elements: " + collection.size());
            return collection;
        } catch (IOException e) {
            System.out.println("File not found or broken: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}