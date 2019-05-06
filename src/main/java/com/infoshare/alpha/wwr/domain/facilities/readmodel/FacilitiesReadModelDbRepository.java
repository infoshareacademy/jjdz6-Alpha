package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import com.infoshare.alpha.wwr.domain.facilities.datastorage.FacilitiesJsonStorage;
import com.infoshare.alpha.wwr.common.Facilities;
import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestScoped
public class FacilitiesReadModelDbRepository implements FacilitiesReadModelDb {

    @Inject
    private FacilitiesJsonStorage storage;

    public void persist(Facilities facilities) {
        this.storage.save(facilities);
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

    public List<Facility> getByQuery(FacilityQuery query) {
        Map<FacilityQueryField, String> facilityQueryFields = query.getQueryFields();


        Facilities facilities = this.storage.load();
        List<Facility> filteredFacilities = facilities.getFacilities();

        if (facilityQueryFields.containsKey(FacilityQueryField.FACILITY_NAME)) {
            String filterName = facilityQueryFields.get(FacilityQueryField.FACILITY_NAME);
            Stream facilitiesStream = filteredFacilities.stream().filter(s->filterName.equals(s.getName()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.containsKey(FacilityQueryField.CITY)) {
            String filterCity = facilityQueryFields.get(FacilityQueryField.CITY);
            Stream facilitiesStream = filteredFacilities.stream().filter(s->filterCity.equals(s.getAddress().getCity()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.containsKey(FacilityQueryField.STREET)) {
            String filterStreet = facilityQueryFields.get(FacilityQueryField.STREET);
            Stream facilitiesStream = filteredFacilities.stream().filter(s->filterStreet.equals(s.getAddress().getStreet()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.containsKey(FacilityQueryField.PHONE)) {
            String filterPhone = facilityQueryFields.get(FacilityQueryField.PHONE);
            Stream facilitiesStream = filteredFacilities.stream().filter(s->filterPhone.equals(s.getAddress().getPhone()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        return filteredFacilities;

    }
}
