package com.infoshare.alpha.wwr.facilities;

import com.infoshare.alpha.wwr.utils.DI;

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
        this.facilitiesReadModelDbRepository.persist();
    }

    public void delete(Facility facility) {

    }

    public void edit(FacilityEditCommand facilityEditCommand) {

    }
}
