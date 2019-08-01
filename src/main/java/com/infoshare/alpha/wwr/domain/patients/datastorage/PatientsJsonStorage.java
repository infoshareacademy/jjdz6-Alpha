package com.infoshare.alpha.wwr.domain.patients.datastorage;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.servlet.utils.WebInfPathResolver;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.*;
import java.util.logging.Logger;

@Stateful
public class PatientsJsonStorage {

    public static final String PATIENTS_FILE_NAME = "patients.json";

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Logger logger = Logger.getLogger(PatientsJsonStorage.class.getName());

    @Inject
    private WebInfPathResolver webInfPathResolver;

    public Patients load() {

        try (Reader reader = new FileReader(this.getPatientsRepoPath())) {

            Patients patients = this.gson.fromJson(reader, Patients.class);

            return patients == null ? new Patients() : patients;
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }

        return new Patients();
    }

    public void save(Patients patients) {

        try (Writer writer = new FileWriter(this.getPatientsRepoPath())) {
            this.gson.toJson(patients, writer);
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
    }

    private String getPatientsRepoPath() {
        return  !webInfPathResolver.getJsonRepositoryPath().isEmpty() ?
                webInfPathResolver.getJsonRepositoryPath() + PATIENTS_FILE_NAME :
                Resources.getResource(PATIENTS_FILE_NAME).getPath();
    }

}
