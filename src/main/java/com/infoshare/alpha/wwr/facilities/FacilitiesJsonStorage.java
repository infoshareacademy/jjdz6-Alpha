package com.infoshare.alpha.wwr.facilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class FacilitiesJsonStorage {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FACILITIES_JSON_FILE = "src/main/resources/facilities.json";

    public static void write(Facilities facilities) {

        try (Writer writer = new FileWriter(FACILITIES_JSON_FILE)) {

            GSON.toJson(facilities, writer);

        } catch (IOException e) {
            System.out.println("File " + FACILITIES_JSON_FILE + " save error");
            System.out.println(e.toString());
        }
    }

    public static Facilities load() {

        try {
            Reader reader = new FileReader(FACILITIES_JSON_FILE);

            return GSON.fromJson(reader, Facilities.class);

        } catch (FileNotFoundException e) {
            System.out.println("File " + FACILITIES_JSON_FILE + " load error");
            System.out.println(e.toString());
        }

        return new Facilities();
    }

}
