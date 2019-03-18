package com.infoshare.alpha.wwr.domain.patients.datastorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

import com.infoshare.alpha.wwr.domain.patients.entity.Patients;
import com.infoshare.alpha.wwr.di.DI;

public class PatientsJsonStorage implements DI {

	private String patientsRepoFilePath;
	private Gson gson;

	public PatientsJsonStorage(String patientsRepoFilePath) {
		this.patientsRepoFilePath = patientsRepoFilePath;
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public Patients load() {
        try (Reader reader = new FileReader(this.patientsRepoFilePath)){

            Patients patients = this.gson.fromJson(reader, Patients.class);

            return patients == null ? new Patients() : patients;
        } catch (IOException e) {
			System.out.println("Exception during reading json file: " + e.getMessage());
		}
        
		return new Patients();
	}
		
	public void save(Patients patients) {
		try (Writer writer = new FileWriter(this.patientsRepoFilePath)) {
			this.gson.toJson(patients, writer);
		} catch (IOException e) {
			System.out.println("Exception during saving json file: " + e.getMessage());
		}
	}
	
}
