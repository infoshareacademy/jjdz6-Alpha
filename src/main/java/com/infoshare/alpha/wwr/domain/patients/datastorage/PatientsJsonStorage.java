package com.infoshare.alpha.wwr.domain.patients.datastorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

import com.infoshare.alpha.wwr.domain.patients.entity.Patients;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class PatientsJsonStorage {

	private static final String PATIENTS_REPO_FILE_PATH = "src/main/resources/"; //TODO refactor to get path from customizable parameter
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public Patients load() {
        try (Reader reader = new FileReader(this.PATIENTS_REPO_FILE_PATH)){

            Patients patients = this.gson.fromJson(reader, Patients.class);

            return patients == null ? new Patients() : patients;
        } catch (IOException e) {
			System.out.println("Exception during reading json file: " + e.getMessage());
		}
        
		return new Patients();
	}
		
	public void save(Patients patients) {
		try (Writer writer = new FileWriter(this.PATIENTS_REPO_FILE_PATH)) {
			this.gson.toJson(patients, writer);
		} catch (IOException e) {
			System.out.println("Exception during saving json file: " + e.getMessage());
		}
	}
	
}
