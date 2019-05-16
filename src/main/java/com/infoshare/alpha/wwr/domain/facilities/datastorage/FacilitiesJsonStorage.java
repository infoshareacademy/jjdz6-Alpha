package com.infoshare.alpha.wwr.domain.facilities.datastorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.utils.Config;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FacilitiesJsonStorage {

    private Gson gson;

    @Inject
    private Config config;

    public Facilities load() {

        String facilitiesRepoFilePath = config.getServletContext().getRealPath("/WEB-INF/json-repository/facilities.json");
        this.gson = new GsonBuilder().setPrettyPrinting().create();

        try (Reader reader = new FileReader(facilitiesRepoFilePath)) {
            Facilities facilities = this.gson.fromJson(reader, Facilities.class);

            return facilities == null ? new Facilities() : facilities;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Facilities();
    }

    public void save(Facilities facilities) {
        String facilitiesRepoFilePath = config.getServletContext().getRealPath("/WEB-INF/json-repository/facilities.json");
        try (Writer writer = new FileWriter(facilitiesRepoFilePath)) {
            this.gson.toJson(facilities, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
