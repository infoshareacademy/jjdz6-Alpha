package com.infoshare.alpha.wwr.domain.facilities.datastorage;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;

import javax.enterprise.context.RequestScoped;
import java.io.*;
import java.net.URL;

@RequestScoped
public class FacilitiesJsonStorage {

    private static final URL FACILITIES_REPO_URL = Resources.getResource("/facilities.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Facilities load() {
        try (Reader reader = new FileReader(FACILITIES_REPO_URL.getPath())) {
            Facilities facilities = this.gson.fromJson(reader, Facilities.class);

            return facilities == null ? new Facilities() : facilities;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Facilities();
    }

    public void save(Facilities facilities) {
        try (Writer writer = new FileWriter(FACILITIES_REPO_URL.getPath())) {
            this.gson.toJson(facilities, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
