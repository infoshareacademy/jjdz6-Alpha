package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import com.infoshare.alpha.wwr.common.Address;
import com.infoshare.alpha.wwr.common.PostalCodeComparator;
import com.infoshare.alpha.wwr.domain.facilities.dao.FacilityDao;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQueryField;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestScoped
public class FacilitiesReadModelDbRepository implements FacilitiesReadModelDb {

    @Inject
    private FacilityDao facilityDao;

    @Override
    public Facilities getAll() {

        Facilities facilities = new Facilities();
        facilities.setFacilities(facilityDao.findAll());

        return facilities;
    }

    @Override
    public Facility getById(int id) {

        return facilityDao.findAll().stream().filter(f -> id == f.getId()).findAny().orElse(null);
    }

    @Override
    public List<Facility> getByName(String name) {
        List<Facility> facilities = facilityDao.findAll();

        return facilities
                .stream()
                .filter(s -> name.equals(s.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Facility> getByCity(String city) {
        List<Facility> facilities = facilityDao.findAll();

        return facilities
                .stream()
                .filter(s -> city.equals(s.getAddress().getCity()))
                .collect(Collectors.toList());
    }


    @Override
    public List<Facility> getByAddress(Address address) {

        List<Facility> facilities = facilityDao.findAll();

        return facilities
                .stream()
                .filter(facility -> facility.getAddress().equals(address))
                .collect(Collectors.toList());
    }

    @Override
    public List<Facility> getByPatient(FacilityPatientQuery query) {

        List<FacilityQueryField> facilityQueryFields = query.getQueryFields();

        List<Facility> facilities = facilityDao.findAll();
        List<Facility> filteredFacilities = new ArrayList<>();

        if (facilityQueryFields.contains(FacilityQueryField.CITY)) {
            String filterCity = query.getPatient().getAddress().getCity();
            Stream facilitiesStream = facilities.stream().filter(s -> filterCity.equals(s.getAddress().getCity()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.contains(FacilityQueryField.STREET)) {
            String filterStreet = query.getPatient().getAddress().getStreet();
            Stream facilitiesStream = filteredFacilities.stream().filter(s -> filterStreet.equals(s.getAddress().getStreet()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.contains(FacilityQueryField.PHONE)) {
            String filterPhone = query.getPatient().getAddress().getPhone();
            Stream facilitiesStream = filteredFacilities.stream().filter(s -> filterPhone.equals(s.getAddress().getPhone()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.contains(FacilityQueryField.POSTAL_CODE)) {
            filteredFacilities.sort(new PostalCodeComparator(query.getPatient().getAddress().getPostalCode()));
        }

        return filteredFacilities;
    }

    @Override
    public List<Facility> getByQuery(FacilityQuery query) {

        Map<FacilityQueryField, String> facilityQueryFields = query.getQueryFields();

        List<Facility> filteredFacilities = facilityDao.findAll();

        if (facilityQueryFields.containsKey(FacilityQueryField.FACILITY_NAME)) {
            String filterName = facilityQueryFields.get(FacilityQueryField.FACILITY_NAME);
            Stream facilitiesStream = filteredFacilities.stream().filter(s -> filterName.equals(s.getName()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.containsKey(FacilityQueryField.CITY)) {
            String filterCity = facilityQueryFields.get(FacilityQueryField.CITY);
            Stream facilitiesStream = filteredFacilities.stream().filter(s -> filterCity.equals(s.getAddress().getCity()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.containsKey(FacilityQueryField.STREET)) {
            String filterStreet = facilityQueryFields.get(FacilityQueryField.STREET);
            Stream facilitiesStream = filteredFacilities.stream().filter(s -> filterStreet.equals(s.getAddress().getStreet()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        if (facilityQueryFields.containsKey(FacilityQueryField.PHONE)) {
            String filterPhone = facilityQueryFields.get(FacilityQueryField.PHONE);
            Stream facilitiesStream = filteredFacilities.stream().filter(s -> filterPhone.equals(s.getAddress().getPhone()));
            filteredFacilities = (List<Facility>) facilitiesStream.collect(Collectors.toList());
        }

        return filteredFacilities;
    }
}
