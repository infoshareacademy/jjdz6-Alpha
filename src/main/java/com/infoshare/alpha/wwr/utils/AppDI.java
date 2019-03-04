package com.infoshare.alpha.wwr.utils;

import java.util.HashMap;
import java.util.Set;

import com.infoshare.alpha.wwr.facilities.FacilitiesDbRepository;
import com.infoshare.alpha.wwr.facilities.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.facilities.FacilitiesReadModel;
import com.infoshare.alpha.wwr.facilities.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.facilities.FacilitiesRepository;
import com.infoshare.alpha.wwr.facilities.FacilitiesService;

// klasa ktora udostepnia wszystkie funkcjonalnosci aplikacji, serwisy i read modele
public final class AppDI {
	
	private HashMap<String, DI> di;
	
	private String facilitiesFilePath;
	private String patientsFilePath;
	
	public AppDI(String facilitiesFilePath, String patientsFilePath) {
		
		this.facilitiesFilePath = facilitiesFilePath;
		this.patientsFilePath = patientsFilePath;
		
		this.di = new HashMap<String, DI>();	
		
		this.initializeDiServices();
	}
	
	public Set<String> getDIServicesNames() {
		
		return this.di.keySet();		
	}
	
	public DI getService(String name) {
		
		if (!this.di.containsKey(name)) {
			// thorw execption di not contains service
		}
		
		return (DI)this.di.get(name);
	}
	
	public void printDIServices() {
		
		for(String serviceName : this.di.keySet()) {
			System.out.println(serviceName);
		}
	}
	
	private void initializeDiServices() {
		
		FacilitiesJsonStorage facilitiesJsonStorage = new FacilitiesJsonStorage(this.facilitiesFilePath);
		FacilitiesReadModelDbRepository facilitiesReadModelDbRepository = new FacilitiesReadModelDbRepository(facilitiesJsonStorage);
		FacilitiesReadModel facilitiesReadModel = new FacilitiesReadModel(facilitiesReadModelDbRepository);
		FacilitiesRepository facilitiesRepository = new FacilitiesDbRepository();
		
		this.di.put("FacilitiesJsonStorage", facilitiesJsonStorage);
		this.di.put("FacilitiesReadModelDbRepository", facilitiesReadModelDbRepository);
		this.di.put("FacilitiesReadModel", facilitiesReadModel);
		this.di.put("FacillitiesService", new FacilitiesService(facilitiesRepository, facilitiesReadModelDbRepository));
	}
}