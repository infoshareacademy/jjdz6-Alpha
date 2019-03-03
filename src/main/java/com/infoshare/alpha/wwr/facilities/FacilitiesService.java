package com.infoshare.alpha.wwr.facilities;

public class FacilitiesService {

    private FacilitiesRepository facilitiesRepository = new FacilitiesRepository();

    public FacilitiesService() {

    }

    public void add(Facility facility) {
        Facilities facilities = this.facilitiesRepository.getAll();
        facilities.add(facility);
        this.facilitiesRepository.persist();
    }

    public void delete(Facility facility) {

    }

    public void edit(FacilityEditCommand facilityEditCommand) {

    }
}
