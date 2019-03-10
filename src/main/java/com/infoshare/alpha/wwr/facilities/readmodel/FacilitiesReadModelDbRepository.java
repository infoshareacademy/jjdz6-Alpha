package com.infoshare.alpha.wwr.facilities.readmodel;

import com.infoshare.alpha.wwr.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.di.DI;
import com.infoshare.alpha.wwr.facilities.entity.Facility;
import com.infoshare.alpha.wwr.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.facilities.query.FacilityQuery;
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

    @Override
    public Facilities getAll() {
        
        return this.storage.load();
    }

    @Override
    public List<Facility> getByName(String name) {
    	Facilities facilities = this.storage.load();
    	
        return facilities.getFacilities().
                stream().
                filter(s->name.equals(s.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Facility> getByCity(String city) {
    	Facilities facilities = this.storage.load();
    	
        return facilities.getFacilities().
                stream().
                filter(s->city.equals(s.getAddress().getCity()))
                .collect(Collectors.toList());
    }
    

    @Override
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

        List<FacilityQueryField> facilityQueryFields = query.getQueryFields();

        Facilities facilities = this.storage.load();
        List<Facility> filteredFacilities = facilities.getFacilities();

        if (facilityQueryFields.contains(FacilityQueryField.CITY)) {
            String filterCity = query.getPatient().getAddress().getCity();
            Stream facilitiesStream = facilities.getFacilities().stream().filter(s->filterCity.equals(s.getAddress().getCity()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.contains(FacilityQueryField.STREET)) {
            String filterStreet = query.getPatient().getAddress().getStreet();
            Stream facilitiesStream = filteredFacilities.stream().filter(s->filterStreet.equals(s.getAddress().getStreet()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.contains(FacilityQueryField.PHONE)) {
            String filterPhone = query.getPatient().getAddress().getPhone();
            Stream facilitiesStream = filteredFacilities.stream().filter(s->filterPhone.equals(s.getAddress().getPhone()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        return filteredFacilities;
    }

    @Override
    public List<Facility> getByQuery(FacilityQuery query) {
        return null;
    }
}
