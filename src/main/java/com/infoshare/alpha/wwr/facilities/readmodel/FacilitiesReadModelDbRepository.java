package com.infoshare.alpha.wwr.facilities.readmodel;

import com.infoshare.alpha.wwr.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.facilities.entity.Facility;
import com.infoshare.alpha.wwr.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.facilities.query.FacilityQueryField;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FacilitiesReadModelDbRepository implements FacilitiesReadModelDb, DI {

    private FacilitiesJsonStorage storage;

    public FacilitiesReadModelDbRepository(FacilitiesJsonStorage storage) {
        try {
            this.storage = storage;
        } catch (NullPointerException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public Facilities getAll() {
        
        return this.storage.load();
    }

    public List<Facility> getByName(String name) {
    	Facilities facilities = this.storage.load();
    	
        return facilities.getFacilities().
                stream().
                filter(s->name.equals(s.getName()))
                .collect(Collectors.toList());
    }

    public List<Facility> getByCity(String city) {
    	Facilities facilities = this.storage.load();
    	
        return facilities.getFacilities().
                stream().
                filter(s->city.equals(s.getAddress().getCity()))
                .collect(Collectors.toList());
    }
    
    
    public List<Facility> getByAddress(Address address) {
    	
    	Facilities facilities = this.storage.load();    	
    	String filterCity = address.getCity();
    	String filterStreet = address.getStreet();
    	String filterPhone = address.getPhone();
    	
    	return facilities.getFacilities().
    			stream().
    			filter(s->filterCity.equals(s.getAddress().getCity()))
    			.filter(s->filterStreet.equals(s.getAddress().getStreet()))
    			.filter(s->filterPhone.equals(s.getAddress().getPhone()))
    			.collect(Collectors.toList());
    }

    @Override
    public List<Facility> getByPatient(FacilityPatientQuery query) {
        //TODO : to implement
        Facilities facilities = this.storage.load();

        Stream facilitiesStrea = facilities.getFacilities().stream();

        List<FacilityQueryField> facilityQueryFields = query.getQueryFields();
//        if (facilityQueryFields.contains(FacilityQueryField.CITY)) {
//            ((Stream) facilitiesStrea).filter();
//        }

        for (FacilityQueryField f : query.getQueryFields()) {

        }


        return null;

    }
}