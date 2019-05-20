package com.infoshare.alpha.wwr.domain.patients.datastorage;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

import javax.ejb.Stateful;
import java.io.*;
import java.net.URL;

@Stateful
public class PatientsJsonStorage {

    private static final URL PATIENTS_REPO_URL = Resources.getResource("patients.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Patients load() {
        try (Reader reader = new FileReader(PATIENTS_REPO_URL.getPath())) {

            Patients patients = this.gson.fromJson(reader, Patients.class);

            return patients == null ? new Patients() : patients;
        } catch (IOException e) {
            System.out.println("Exception during reading json file: " + e.getMessage());
        }

        return new Patients();
    }

    public void save(Patients patients) {
        try (Writer writer = new FileWriter(PATIENTS_REPO_URL.getPath())) {
            this.gson.toJson(patients, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

}
