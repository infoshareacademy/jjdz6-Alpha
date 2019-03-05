package com.infoshare.alpha.wwr.facilities;

import com.infoshare.alpha.wwr.facilities.command.FacilityEditCommand;
import com.infoshare.alpha.wwr.facilities.entity.Facilities;
import com.infoshare.alpha.wwr.facilities.entity.Facility;
import com.infoshare.alpha.wwr.facilities.readModel.FacilitiesReadModelDbRepository;
import com.infoshare.alpha.wwr.facilities.repository.FacilitiesRepository;
import com.infoshare.alpha.wwr.di.DI;

public class FacilitiesService implements DI{

    private FacilitiesReadModelDbRepository facilitiesReadModelDbRepository;
    private FacilitiesRepository facilitiesDbRepository;

    public FacilitiesService(
    		FacilitiesRepository facilitiesDbRepository,
    		FacilitiesReadModelDbRepository facilitiesReadModelDbRepository
    		) {
    		this.facilitiesDbRepository = facilitiesDbRepository;
    		this.facilitiesReadModelDbRepository = facilitiesReadModelDbRepository;   		
    }

    public void add(Facility facility) {
        Facilities facilities = this.facilitiesReadModelDbRepository.getAll();
        facilities.add(facility);
        this.facilitiesDbRepository.persist(facilities);
    }

    public void delete(Facility facility) {

        // funckcja do usuwania placówki

    }

    public void edit(FacilityEditCommand facilityEditCommand) {

        // funkcja do edycji placowki

    }
}
