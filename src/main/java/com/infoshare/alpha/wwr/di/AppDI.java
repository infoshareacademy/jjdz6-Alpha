package com.infoshare.alpha.wwr.di;

import java.util.HashMap;

import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.domain.facilities.repository.FacilitiesRepository;
import com.infoshare.alpha.wwr.domain.facilities.FacilitiesService;

// klasa ktora udostepnia wszystkie funkcjonalnosci aplikacji, serwisy i read modele z jednego miejsca
// DI - dependency injection
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
	
	private void initializeDiServices() {
		
		FacilitiesJsonStorage facilitiesJsonStorage = new FacilitiesJsonStorage(this.facilitiesFilePath);
		FacilitiesReadModelDbRepository facilitiesReadModelDbRepository = new FacilitiesReadModelDbRepository(facilitiesJsonStorage);
		FacilitiesReadModel facilitiesReadModel = new FacilitiesReadModel(facilitiesReadModelDbRepository);
		FacilitiesRepository facilitiesRepository = new FacilitiesDbRepository(facilitiesJsonStorage);
		
		this.di.put(FacilitiesJsonStorage.class.toString(), facilitiesJsonStorage);
		this.di.put(FacilitiesReadModelDbRepository.class.toString(), facilitiesReadModelDbRepository);
		this.di.put(FacilitiesReadModel.class.toString(), facilitiesReadModel);
		this.di.put(FacilitiesService.class.toString(), new FacilitiesService(facilitiesRepository, facilitiesReadModelDbRepository));
	}
		
	public DI getService(String name) {
		
		if (!this.di.containsKey(name)) {
			// TODO: tutaj nalezy rzucac wyjatek 
			System.out.println("Exception : Service " + name + " not found .");
		}
		
		return (DI)this.di.get(name);
	}
	
	public void printDIServices() {
		
		for(String serviceName : this.di.keySet()) {
			System.out.println(serviceName);
		}
	}
	

}