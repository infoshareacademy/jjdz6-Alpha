package com.infoshare.alpha.wwr;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FacilitiesRepository {


    private List<Facility> facilities;

    public FacilitiesRepository(String jsonRepoFilePath) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(jsonRepoFilePath));

        Gson gson = new Gson();
        ArrayList json = gson.fromJson(bufferedReader, ArrayList.class);

        JsonParser parser = new JsonParser();
        for (Object o : json) {
            System.out.println(o.toString());
            JsonElement element = parser.parse(o.toString());

//            JsonElement element = parser.parse(o.toString());
//            JsonObject jsonFacility = element.getAsJsonObject();
//            System.out.println(jsonFacility.toString());
        }

//        System.out.println(json.toString());


//        JsonParser parser = new JsonParser();
//        JsonElement element = parser.parse(json.toString());
//        System.out.println(element.getAsJsonArray().toString());


    }

    public FacilitiesRepository() {
        this.facilities = new ArrayList<>();
        this.facilities.add(new Facility("WWR1", new Address("Gdańsk", "Nowe Ogroady 23", "+48 564 123 123")));
        this.facilities.add(new Facility("WWR2", new Address("Gdańsk", "Al. Gruwaldzka 223", "+48 564 123 555")));
        this.facilities.add(new Facility("WWR3", new Address("Sopot", "Zwyciestwa 17", "+48 754 123 123")));
        this.facilities.add(new Facility("WWR4", new Address("Gdynia", "Kolejowa 23", "+48 112 123 123")));
        this.facilities.add(new Facility("WWR5", new Address("Gdynia", "Swietojanska 110", "+48 456 123 123")));
    }


    public List<Facility> getAll() {

        return this.facilities;
    }

    public List<Facility> getByName(String name) {

        return this.facilities.
                stream().
                filter(s->name.equals(s.getName()))
                .collect(Collectors.toList());
    }

    public List<Facility> getByCity(String city) {

        return this.facilities.
                stream().
                filter(s->city.equals(s.getAddress().getCity()))
                .collect(Collectors.toList());
    }
}
