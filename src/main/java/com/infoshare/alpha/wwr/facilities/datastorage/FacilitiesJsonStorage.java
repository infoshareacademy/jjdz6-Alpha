package com.infoshare.alpha.wwr.facilities.datastorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.di.DI;

public class FacilitiesJsonStorage implements DI {

	private String facilitiesRepoFilePath;
	private Gson gson;

	public FacilitiesJsonStorage(String facilitiesRepoFilePath) {
		this.facilitiesRepoFilePath = facilitiesRepoFilePath;
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public Facilities load() {
        try {
            Reader reader = new FileReader(this.facilitiesRepoFilePath);
            Facilities facilities = this.gson.fromJson(reader, Facilities.class);

            return facilities == null ? new Facilities() : facilities;
        } catch (FileNotFoundException e) {
            System.out.println("File " + this.facilitiesRepoFilePath + " load error");
            System.out.println(e.toString());
        }
        
		return new Facilities();
	}
		
	public void save(Facilities facilities) {
		try {
			Writer writer = new FileWriter(this.facilitiesRepoFilePath);
			this.gson.toJson(facilities, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
