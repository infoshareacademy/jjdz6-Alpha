package com.infoshare.alpha.wwr.facilities;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;

import com.infoshare.alpha.wwr.utils.DI;

public class FacilitiesReadModelDbRepository implements FacilitiesReadModelDb, DI {

    private Facilities facilities;
    private FacilitiesJsonStorage storage;

    public FacilitiesReadModelDbRepository(FacilitiesJsonStorage storage) {
    		this.storage = storage;
    		this.loadData();
    }
    
    public FacilitiesReadModelDbRepository(){

        this.facilities = FacilitiesJsonStorage.load();
    }
    
    private void loadData() {
    		if (this.storage == null) {
    			// throw exception storage is not initialized
    			System.out.println("Storage not initialized");
    		}
    		
    		if (this.facilities == null) {
    			this.facilities = this.storage.loadResources();
    		}
    		
    }

    public Facilities getAll() {
        
        return this.facilities;
    }

    // TODO: tutaj wyprosowac 
//    public ArrayList<Facilities> getByName(String name) {
//
//    		return new ArrayList<Facilities>();
//        return this.facilities.getFacilities().
//                stream().
//                filter(s->name.equals(s.getName()))
//                .collect(Collectors.toList());
//    }
//
//    public ArrayList<Facilities> getByCity(String city) {
//    	
//    		return new ArrayList<Facilities>();
//
//        return this.facilities.getFacilities().
//                stream().
//                filter(s->city.equals(s.getAddress().getCity()))
//                .collect(Collectors.toList());
//    }

    // extract to FacilitiesDbRepository
    public void persist() {
        FacilitiesJsonStorage.write(this.facilities);
    }
}
