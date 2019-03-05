package com.infoshare.alpha.wwr.di;

import java.util.HashMap;

import com.infoshare.alpha.wwr.facilities.repository.FacilitiesDbRepository;
import com.infoshare.alpha.wwr.facilities.dataStorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.facilities.readModel.FacilitiesReadModel;
import com.infoshare.alpha.wwr.facilities.readModel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.facilities.repository.FacilitiesRepository;
import com.infoshare.alpha.wwr.facilities.FacilitiesService;

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
	
//	public Set<String> getDIServicesNames() {
//
//		return this.di.keySet();
//	}
	
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
		
		this.di.put(FacilitiesJsonStorage.class.toString(), facilitiesJsonStorage);
		this.di.put(FacilitiesReadModelDbRepository.class.toString(), facilitiesReadModelDbRepository);
		this.di.put(FacilitiesReadModel.class.toString(), facilitiesReadModel);
		this.di.put(FacilitiesService.class.toString(), new FacilitiesService(facilitiesRepository, facilitiesReadModelDbRepository));
	}
}