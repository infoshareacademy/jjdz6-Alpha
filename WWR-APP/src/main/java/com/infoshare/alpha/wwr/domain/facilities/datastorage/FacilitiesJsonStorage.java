package com.infoshare.alpha.wwr.domain.facilities.datastorage;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.servlet.utils.WebInfPathResolver;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.*;
import java.util.logging.Logger;

@Stateful
public class FacilitiesJsonStorage {

    public static final String FACILITIES_FILE_NAME = "facilities.json";

    @Inject
    private WebInfPathResolver webInfPathResolver;

    private Logger logger = Logger.getLogger(FacilitiesJsonStorage.class.getName());

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Facilities load() {
        try (Reader reader = new FileReader(this.getFacilitiesRepoPath())) {
            Facilities facilities = this.gson.fromJson(reader, Facilities.class);
            return facilities;
        } catch (IOException e) {
           logger.severe(e.getMessage());
        }

        return new Facilities();
    }

    public void save(Facilities facilities) {

        try (Writer writer = new FileWriter(this.getFacilitiesRepoPath())) {
            this.gson.toJson(facilities, writer);
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
    }

    private String getFacilitiesRepoPath() {

        return  !webInfPathResolver.getJsonRepositoryPath().isEmpty() ?
                webInfPathResolver.getJsonRepositoryPath() + FACILITIES_FILE_NAME :
                Resources.getResource(FACILITIES_FILE_NAME).getPath();
    }
}
