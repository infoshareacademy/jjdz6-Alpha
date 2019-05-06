package com.infoshare.alpha.wwr.domain.facilities;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.Facilities;
import com.infoshare.alpha.wwr.common.Facility;
import com.infoshare.alpha.wwr.domain.facilities.command.UploadCommand;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDb;
import com.infoshare.alpha.wwr.utils.FacilitiesException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestScoped
public class FacilitiesService {

    @Inject
    private FacilitiesReadModelDb facilitiesReadModelDb;

    public Facilities getAll() {

        return facilitiesReadModelDb.getAll();
    }

    public List<Facility> getByName(String name) {
        Facilities facilities = facilitiesReadModelDb.getAll();

        return facilities.getFacilities().
                stream().
                filter(s->name.equals(s.getName()))
                .collect(Collectors.toList());
    }

    public List<Facility> getByCity(String city) {
        Facilities facilities = facilitiesReadModelDb.getAll();

        return facilities.getFacilities().
                stream().
                filter(s->city.equals(s.getAddress().getCity()))
                .collect(Collectors.toList());
    }

    public List<Facility> getByAddress(Address address) {

        Facilities facilities = facilitiesReadModelDb.getAll();
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

        Facilities facilities = facilitiesReadModelDb.getAll();
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


        Facilities facilities = facilitiesReadModelDb.getAll();
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

    public void add(Facility facility) throws FacilitiesException {

        Facilities facilities = facilitiesReadModelDb.getAll();

        if (facilities.getFacilities().contains(facility)) {

            throw FacilitiesException.facilityExists(facility.getName());
        }

        facilities.add(facility);
        facilitiesReadModelDb.persist(facilities);
    }

    public void delete(Facility facility) throws FacilitiesException {

        facilitiesReadModelDb.delete(facility);
    }

    public void edit(Facility oldFacility, Facility editedFacility) throws FacilitiesException {

        facilitiesReadModelDb.edit(oldFacility, editedFacility);
    }
    
    public void upload(UploadCommand uploadCommand) {
    	
    	// funkcja ktora wrzuca do repozutorium dodatkowe placowki 
    	// 1. zaciagnij aktualne placowki z repozytorium placowek -> Facilities facilities = this.facilitiesReadModelDbRepository.getAll();
    	// 2. wczytaj placowki z pliku -> wykorzystaj : FacilitiesJsonStorage
    	// 3. po poprawnym wczytaniu zmerguj dwie kolekcje obiektow
    	// 4. zapisz zmergowana kolekcje do repozytorium -> wykorzystaj : this.facilitiesDbRepository.persist(facilities);
    }
}
