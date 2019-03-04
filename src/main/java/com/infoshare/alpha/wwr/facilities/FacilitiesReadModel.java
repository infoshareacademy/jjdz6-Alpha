package com.infoshare.alpha.wwr.facilities;

//import java.util.List;

import com.infoshare.alpha.wwr.utils.DI;


// klasa ktora udostepnia metody odczytujace dane dot. placowek


public class FacilitiesReadModel implements DI {
	
	private FacilitiesReadModelDb repository;

	public FacilitiesReadModel(FacilitiesReadModelDb repository) {
		this.repository = repository;
	}
	
    public Facilities getAll() {
    	
    		return this.repository.getAll();
    }

//    public List<Facility> getByName(String name) {
//    	
//    		return this.repository.getByName(name);
//    }
//
//    public List<Facility> getByCity(String city) {
//    	
//    		return this.repository.getByCity(city);
//    }

}