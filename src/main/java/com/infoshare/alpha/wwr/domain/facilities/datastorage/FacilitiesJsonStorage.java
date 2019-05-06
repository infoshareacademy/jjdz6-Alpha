package com.infoshare.alpha.wwr.domain.facilities.datastorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;

import javax.enterprise.context.RequestScoped;
import java.io.*;

@RequestScoped
public class FacilitiesJsonStorage {

	private static final String FACILITIES_REPO_FILE_PATH = "/home/szymon/Desktop/jjdz6-Alpha/src/main/webapp/WEB-INF/json-repository/facilities.json";
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public Facilities load() {
        try (Reader reader = new FileReader(FACILITIES_REPO_FILE_PATH)) {
            Facilities facilities = this.gson.fromJson(reader, Facilities.class);

            return facilities == null ? new Facilities() : facilities;
        } catch (IOException e) {
			e.printStackTrace();
		}
        
		return new Facilities();
	}
		
	public void save(Facilities facilities) {
		try (Writer writer = new FileWriter(FACILITIES_REPO_FILE_PATH)){
			this.gson.toJson(facilities, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
