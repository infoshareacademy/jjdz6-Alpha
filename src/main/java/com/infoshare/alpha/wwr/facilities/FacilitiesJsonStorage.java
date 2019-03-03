package com.infoshare.alpha.wwr.facilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.net.URL;

// TODO: wyniesci plik na zewnatrz
public class FacilitiesJsonStorage {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FACILITIES_JSON_FILE = System.getProperty("user.dir") + "/classes/" + "facilities.json";

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

//            File file = new File("resources/facilities.json");
//            String absolutePath = file.getAbsolutePath();

            URL resource = FacilitiesJsonStorage.class.getResource("/facilities.json");

            System.out.println("absolute path = " + resource.getFile());

            Facilities facilities = GSON.fromJson(reader, Facilities.class);

            return facilities == null ? new Facilities() : facilities;

        } catch (FileNotFoundException e) {
            System.out.println("File " + FACILITIES_JSON_FILE + " load error");
            System.out.println(e.toString());
        }

        return new Facilities();
    }

}
