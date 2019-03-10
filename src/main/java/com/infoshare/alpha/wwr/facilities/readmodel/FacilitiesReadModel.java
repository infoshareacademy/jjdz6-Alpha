package com.infoshare.alpha.wwr.facilities.readmodel;

import java.util.List;

import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.facilities.entity.Facility;
import com.infoshare.alpha.wwr.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.facilities.query.FacilityQuery;

/**
 * Class read data from facilities repository also eg. nearest patients facilities or by query
 * 
 * @author pkowerzanow
 *
 */
public class FacilitiesReadModel implements DI {
	
	private FacilitiesReadModelDb repository;

	public FacilitiesReadModel(FacilitiesReadModelDb repository) {

		this.repository = repository;
	}
	
    public Facilities getAll() {
    	
    		return this.repository.getAll();
    }

    public List<Facility> getByName(String name) {
    	
    		return this.repository.getByName(name);
    }

    public List<Facility> getByCity(String city) {
    	
    		return this.repository.getByCity(city);
    }
    
    public List<Facility> getByPatientCity(FacilityPatientQuery query) {
    	
    	String patientsCity = query.getPatient().getAddress().getCity();
    	
    	return this.repository.getByCity(patientsCity);
    }

    public List<Facility> getByPatient(FacilityPatientQuery query) {

    	return this.repository.getByPatient(query);
    }

    public List<Facility> getByQuery(FacilityQuery query) {

    	return this.repository.getByQuery(query);
    }






}