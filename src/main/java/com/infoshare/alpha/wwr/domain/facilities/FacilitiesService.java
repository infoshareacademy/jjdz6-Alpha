package com.infoshare.alpha.wwr.domain.facilities;

import com.infoshare.alpha.wwr.domain.facilities.command.FacilityAddCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityDeleteCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.FacilityEditCommand;
import com.infoshare.alpha.wwr.domain.facilities.command.UploadCommand;
import com.infoshare.alpha.wwr.utils.FacilitiesException;
import com.infoshare.alpha.wwr.common.Facilities;
import com.infoshare.alpha.wwr.common.Facility;
import com.infoshare.alpha.wwr.domain.facilities.readmodel.FacilitiesReadModelDbRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FacilitiesService {

    @Inject
    private FacilitiesReadModelDbRepository repository;

    public void add(FacilityAddCommand command) throws FacilitiesException {

        Facilities facilities = this.repository.getAll();

        if (facilities.getFacilities().contains(command.getFacility())) {

            throw FacilitiesException.facilityExists(command.getFacility().getName());
        }

        facilities.add(command.getFacility());
        this.repository.persist(facilities);
    }

    public void delete(FacilityDeleteCommand command) throws FacilitiesException {

        Facilities facilities = this.repository.getAll();
        if (facilities.getFacilities().contains(command.getFacility())) {
            facilities.getFacilities().remove(command.getFacility());
            this.repository.persist(facilities);
        } else {
            throw FacilitiesException.facilityNotFound(command.getFacility().getName());
        }
    }

    public void edit(FacilityEditCommand command) throws FacilitiesException {

        Facilities facilities = this.repository.getAll();
        Integer oldFacilityIndex;
        if (facilities.getFacilities().contains(command.getOldFacility())) {
            oldFacilityIndex = facilities.getFacilities().indexOf(command.getOldFacility());
        } else {
            throw FacilitiesException.facilityNotFound(command.getOldFacility().getName());
        }
        for (Facility facility : facilities.getFacilities()) {
            if (facility.equals(command.getEditedFacility())) {
                throw FacilitiesException.facilityExists(command.getEditedFacility().getName());
            }
        }
        facilities.getFacilities().remove(command.getOldFacility());
        facilities.getFacilities().add(oldFacilityIndex, command.getEditedFacility());
        this.repository.persist(facilities);
    }
    
    public void upload(UploadCommand uploadCommand) {
    	
    	// funkcja ktora wrzuca do repozutorium dodatkowe placowki 
    	// 1. zaciagnij aktualne placowki z repozytorium placowek -> Facilities facilities = this.facilitiesReadModelDbRepository.getAll();
    	// 2. wczytaj placowki z pliku -> wykorzystaj : FacilitiesJsonStorage
    	// 3. po poprawnym wczytaniu zmerguj dwie kolekcje obiektow
    	// 4. zapisz zmergowana kolekcje do repozytorium -> wykorzystaj : this.facilitiesDbRepository.persist(facilities);
    }
}
