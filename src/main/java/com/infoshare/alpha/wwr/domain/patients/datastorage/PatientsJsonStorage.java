package com.infoshare.alpha.wwr.domain.patients.datastorage;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.servlet.utils.WebInfPathResolver;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.*;

@Stateful
public class PatientsJsonStorage {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Inject
    private WebInfPathResolver webInfPathResolver;

    public Patients load() {

        try (Reader reader = new FileReader(this.getPatientsRepoPath())) {

            Patients patients = this.gson.fromJson(reader, Patients.class);

            return patients == null ? new Patients() : patients;
        } catch (IOException e) {
            System.out.println("Exception during reading json file: " + e.getMessage());
        }

        return new Patients();
    }

    public void save(Patients patients) {

        try (Writer writer = new FileWriter(this.getPatientsRepoPath())) {
            this.gson.toJson(patients, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    private String getPatientsRepoPath() {
        return  !webInfPathResolver.getJsonRepositoryPath().isEmpty() ?
                webInfPathResolver.getJsonRepositoryPath() + "patients.json" :
                Resources.getResource("patients.json").getPath();
    }

}
