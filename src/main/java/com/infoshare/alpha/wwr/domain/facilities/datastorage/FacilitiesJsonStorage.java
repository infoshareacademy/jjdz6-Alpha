package com.infoshare.alpha.wwr.domain.facilities.datastorage;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.servlet.utils.WebInfPathResolver;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.*;

@Stateful
public class FacilitiesJsonStorage {

    @Inject
    private WebInfPathResolver webInfPathResolver;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Facilities load() {
        try (Reader reader = new FileReader(this.getFacilitiesRepoPath())) {
            Facilities facilities = this.gson.fromJson(reader, Facilities.class);
            return facilities;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Facilities();
    }

    public void save(Facilities facilities) {

        try (Writer writer = new FileWriter(this.getFacilitiesRepoPath())) {
            this.gson.toJson(facilities, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFacilitiesRepoPath() {

        return  !webInfPathResolver.getJsonRepositoryPath().isEmpty() ?
                webInfPathResolver.getJsonRepositoryPath() + "facilities.json" :
                Resources.getResource("facilities.json").getPath();
    }
}
