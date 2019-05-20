package com.infoshare.alpha.wwr.domain.facilities.readmodel;

import com.infoshare.alpha.wwr.domain.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.domain.facilities.entity.Facility;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityPatientQuery;
import com.infoshare.alpha.wwr.domain.facilities.query.FacilityQuery;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Class read data from facilities repository also eg. nearest patients facilities or by query
 *
 * @author pkowerzanow
 */

@RequestScoped
public class FacilitiesReadModel {

    @Inject
    private FacilitiesReadModelDb repository;

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